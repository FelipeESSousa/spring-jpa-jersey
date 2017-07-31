package br.com.cinq.spring.data.sample.resource;

import java.io.Serializable;
import java.util.List;

public class ResponseMeta implements Serializable {

    private static final long serialVersionUID = 1323278432780170679L;

    private Meta meta;
    private List<?> records;

    public ResponseMeta() {
        super();
    }

    public ResponseMeta(Meta meta, List<?> records) {
        super();
        this.meta = meta;
        this.records = records;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<?> records) {
        this.records = records;
    }

}
