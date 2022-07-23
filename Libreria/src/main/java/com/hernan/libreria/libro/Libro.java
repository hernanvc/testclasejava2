package com.hernan.libreria.libro;

import com.hernan.libreria.autor.Autor;
import com.hernan.libreria.categoria.Categoria;
import com.hernan.libreria.copia.Copia;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String titulo;

    private Date year ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "categoriaid")
    Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "autorid")
    private Autor autor;


    @OneToMany(mappedBy = "libro")
    private List<Copia> copia;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Copia> getCopia() {
        return copia;
    }

    public void setCopia(List<Copia> copia) {
        this.copia = copia;
    }
}
