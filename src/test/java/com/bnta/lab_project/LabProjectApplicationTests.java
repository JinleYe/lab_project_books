package com.bnta.lab_project;

import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LabProjectApplicationTests {

    @Autowired
    AuthorRepository authorRepository;


    @Test
    void contextLoads() {
    }

    // Author Tests
    @Test
    public void testGetAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        assertThat(authors.size()).isEqualTo(11);
    }

    @Test
    public void testFindAuthorByNameContainingIgnoreCase(){
        List<Author> list1 = authorRepository.findAuthorsByNameIsContainingIgnoreCase("robert");
        assertThat(list1.size()).isEqualTo(1);
    }

    @Test
    public void testDeleteAuthorById(){
        authorRepository.deleteById(1L);
        List<Author> authors = authorRepository.findAll();
        assertThat(authors.size()).isEqualTo(10);
    }

    // 



}
