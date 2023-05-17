/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelperClasses;

import java.io.Serializable;

/**
 *
 * @author Vijay Rana
 */
public class responseClass<T> implements Serializable{
    T data;
    String message;
    String status;
    String errors;
    int statusCode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public responseClass(T data, String message, String status, String errors, int statusCode) {
        this.data = data;
        this.message = message;
        this.status = status;
        this.errors = errors;
        this.statusCode = statusCode;
    }

    public responseClass() {
    }

}
