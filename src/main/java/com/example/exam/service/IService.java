package com.example.exam.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T t);

    void deleteById(Long id);
}
