package br.com.bnck.admin.catalogo.application;

import br.com.bnck.admin.catalogo.domain.category.Category;

public class UseCase {
    public Category execute() {
        return new Category();
    }
}