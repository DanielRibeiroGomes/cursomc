package br.com.cursomc.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private Long timeStampo;

    public StandardError(Integer status, String msg, Long timeStampo) {
        this.status = status;
        this.msg = msg;
        this.timeStampo = timeStampo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStampo() {
        return timeStampo;
    }

    public void setTimeStampo(Long timeStampo) {
        this.timeStampo = timeStampo;
    }
}
