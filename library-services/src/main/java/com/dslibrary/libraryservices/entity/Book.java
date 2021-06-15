package com.dslibrary.libraryservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
public class Book implements Serializable {
    @Id
    private String isbn;
    private String name;
    private String author;
    private int version;
    private String coverPic;
}