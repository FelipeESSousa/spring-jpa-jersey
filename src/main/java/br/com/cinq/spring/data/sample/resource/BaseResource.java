package br.com.cinq.spring.data.sample.resource;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.cinq.spring.data.sample.exception.EntityNotFoundException;

@CrossOrigin
public class BaseResource {

    protected void checkNotNull(Optional<?> optional, String resourceName) {
        if (!optional.isPresent()
                || (optional.get() instanceof Collection && ((Collection<?>) optional.get()).isEmpty())
                || (optional.get() instanceof Page && !((Page<?>) optional.get()).hasContent())) {
            throw new EntityNotFoundException(resourceName);
        }
    }

    protected ResponseEntity<?> buildResponse(HttpStatus status) {
        return buildResponse(status, Optional.empty());
    }

    protected ResponseEntity<?> buildResponse(final HttpStatus status, Optional<?> entity) {
        if (entity.isPresent() && entity.get() instanceof Page) {
            Page<?> page = (Page<?>) entity.get();
            return buildResponse(status, page);
        }
        return buildResponse(status, entity, 0, 50);
    }

    private ResponseEntity<?> buildResponse(HttpStatus status, Page<?> page) {
        return buildResponse(status, null, Optional.ofNullable(page.getContent()), page.getNumber(),
                page.getNumberOfElements(), null);
    }

    protected ResponseEntity<?> buildResponse(final HttpStatus status, final Optional<?> entity, final Integer page,
            final Integer size) {
        return buildResponse(status, null, entity, page, size, null);
    }

    @SuppressWarnings("unchecked")
    private ResponseEntity<?> buildResponse(final HttpStatus status, final MultiValueMap<String, String> headers,
            final Optional<?> entity, Integer page, Integer size, Integer totalRecords) {
        final List<Object> records = new ArrayList<>();

        if (entity.isPresent()) {
            if (entity.get() instanceof Collection) {
                records.addAll((Collection<Object>) entity.get());
            } else {
                records.add(entity.get());
            }
        }

        page = page == null ? 0 : page;
        size = size == null ? records.size() : size;

        final ResponseMeta body = new ResponseMeta();
        body.setMeta(new Meta(getServer(), size, page, records.size(), totalRecords));

        body.setRecords(records);

        return new ResponseEntity<>(body, headers, status);
    }

    private static String getServer() {
        try {
            return InetAddress.getLocalHost().toString();
        } catch (final Exception e) {
            return "unkown";
        }
    }

}
