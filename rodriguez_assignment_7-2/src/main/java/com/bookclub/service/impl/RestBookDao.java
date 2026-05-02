/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class RestBookDao implements BookDao {


    /*
     * Default constructor for the MemBookDao class.
     * @return returns an instance of MemBookDao with a list of 5 books.
     */
    public RestBookDao() {
    } // end constructor

    public Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "https://openlibrary.org/api/books";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = rest.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        String jsonBookList = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBookList);
    }

    @Override
    public List<Book> list() {
        String isbnString = "ISBN:9780593099322,9780261102361,9780261102378,9780590302715,9780316769532";
        Object doc = getBooksDoc(isbnString);
        System.out.println(doc.toString());
        List<Book> books = new ArrayList();
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitles = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        for (int index = 0; index < titles.size(); index++) {
            String title = titles.get(index); // Because we are indexing through titles.size(), we don't need to check this one
            String isbn = isbns.size() > index ? isbns.get(index) : "N/A";
            String desc = subtitles.size() > index ? subtitles.get(index) : "N/A";
            String infoUrl = infoUrls.size() > index ? infoUrls.get(index) : "N/A";
            int numOfPages = pages.size() > index ? pages.get(index) : 0;
            books.add(new Book(isbn, title, desc, infoUrl, numOfPages));
        }

        return books;
    }

    @Override
    public Book find(String key) {

        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitles = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitles.size() > 0 ? subtitles.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        return new Book(isbn, title, desc, infoUrl, numOfPages);
    }
}
