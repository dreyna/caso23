package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="TBL_LIBROS")
public class Libro {
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLibros")
    @SequenceGenerator(name = "seqLibros", allocationSize = 1, sequenceName = "SEQ_LIBROS")
    private Long id=0L;
	@Column(name = "TITULO")
	@NotNull @NotBlank    
    private String titulo;
	@Column(name = "PAGINAS")
	@NotNull @NotBlank    
    private Integer paginas;
	@Column(name = "EDICION")
	@NotNull @NotBlank    
    private Integer edicion;
	
	@ManyToOne
    @JoinColumn(name="AUTOR_ID", nullable = false)
    private Autor autor;
	@ManyToOne
    @JoinColumn(name="CATEGORIA_ID", nullable = false)
    private Categoria categoria;
	@ManyToOne
    @JoinColumn(name="EDITORIl_ID", nullable = false)
    private Editorial editorial;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "libro")
	@JsonIgnore
	private Set<Alquiler> alquileres;
	
}
