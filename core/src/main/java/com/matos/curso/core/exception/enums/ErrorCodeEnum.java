package com.matos.curso.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalido", "ON-0001"),
    ON0002("Tax Number indisponível", "ON-0002"),
    ON0003("Email indisponível", "ON-0003"),
    ON0004("Houve um erro na criação do usuário", "ON-0004"),

    TR0001("Usuário lojista não tem a função transferência disponível", "TR-0001"),
    TR0002("Saldo indisponível", "TR-0002"),
    TR0003("Houve um erro ao realizar a transferência", "TR-0003"),
    TR0004("Transferência não autorizada", "TR-0004"),

    TRP0001("Pin inválido", "TRP-0001"),

    WA0001("Carteira não encontrada", "WA-0001"),

    NO0001("Houve um erro na notificação do usuário", "NO-0001"),

    ATH0001("Houve um erro na autenticação", "ATH-0001"),
    ATH0002("Invalid request", "ATH-0002"),

    PIN0001("Pin de transação bloqueado", "PIN-0001"),
    PIN0002("Pin incorreto %d tentativa(s) restante(s)", "PIN-0002"),

    ;
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String pin0002GetMessage(Integer attempt){
        return String.format(PIN0002.message, attempt);
    }
}
