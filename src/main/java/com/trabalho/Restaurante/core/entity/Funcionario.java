package com.trabalho.Restaurante.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "\"USER\"")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String cargo;

	

	private Float salario;

	

	public Funcionario() {
	}

	public Funcionario(Long id, String name, String email, String cargo, Float salario) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
	}
		

	private Funcionario(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.email = builder.email;
		this.cargo = builder.cargo;
				this.salario = builder.salario;
							}
						
							public Long getId() {
								return id;
							}
						
							public void setId(Long id) {
								this.id = id;
							}
						
							public String getName() {
								return name;
							}
						
							public void setName(String name) {
								this.name = name;
							}
						
							public String getEmail() {
								return email;
							}
						
							public void setEmail(String email) {
								this.email = email;
							}
						
							public static Builder builder() {
								return new Builder();
							}
						
							public String getCargo() {
								return cargo;
							}
						
							public void setCargo(String cargo) {
								this.cargo = cargo;
							}

							public Float getSalario() {
								return salario;
							}
						
							public void setSalario(Float salario) {
								this.salario = salario;
							}
							public static class Builder {
						
								public Float salario;
				
								public String cargo;
		
				private Long id;

		private String name;

		private String email;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Funcionario build() {
			return new Funcionario(this);
		}

	}

    public String getSenha() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getSenha'");
    }

    public boolean isAtivo() {
        // 
        throw new UnsupportedOperationException("Unimplemented method 'isAtivo'");
    }

}
