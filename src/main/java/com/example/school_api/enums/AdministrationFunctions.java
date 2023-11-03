package com.example.school_api.enums;

public enum AdministrationFunctions {
    TESOURARIA("testousaria"),
    ALMOXARIFADO("almoxarifado"),
    ADMINISTRACAO("administracao"),
    SERVICO_SOCIAL("serviço social"),
    DIRETORIA("diretoria"),
    CONTABILIDADE("contabilidade");

    private String administrationFunctions;

    AdministrationFunctions(String function){
        this.administrationFunctions = function;
    }

    public String getAdministrationFunctions(){
        return administrationFunctions;
    }

}
