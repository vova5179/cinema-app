package org.example.dao.impl;

import org.example.dao.AbstractDao;
import org.example.dao.MovieDao;
import org.example.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
