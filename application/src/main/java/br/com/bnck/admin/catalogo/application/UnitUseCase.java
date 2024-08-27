package br.com.bnck.admin.catalogo.application;

public abstract class UnitUseCase<IN> {
    public abstract void execute(IN anIn);
}