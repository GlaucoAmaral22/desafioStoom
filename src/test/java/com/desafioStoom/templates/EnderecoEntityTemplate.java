package com.desafioStoom.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.desafioStoom.repository.entity.EnderecoEntity;

public class EnderecoEntityTemplate implements TemplateLoader {

    public static final String TEMPLATE_VALIDO_ENDERECO = "Adrress Valid";
    public static final String TEMPLATE_VALIDO_ENDERECO_SAVED = "Saved Valid Adrress";
    public static final String TEMPLATE_VALIDO_ENDERECO_TO_UPDATE = "Update Valid Adrress";
    public static final String TEMPLATE_VALIDO_ENDERECO_UPDATED = "Updated Valid Adrress";




    @Override
    public void load() {
        Fixture.of(EnderecoEntity.class).addTemplate(TEMPLATE_VALIDO_ENDERECO, new Rule(){{
            add("streetName", "Washington Luís");
            add("number", 114);
            add("complement", "casa");
            add("neighbourhood", "Centro");
            add("city", "Amparo");
            add("state", "SP");
            add("country", "Brasil");
            add("zipcode", "13900020");
            add("latitude", null);
            add("longitude", null);
        }});

        Fixture.of(EnderecoEntity.class).addTemplate(TEMPLATE_VALIDO_ENDERECO_SAVED, new Rule(){{
            add("id", 1L);
            add("streetName", "Washington Luís");
            add("number", 114);
            add("complement", "casa");
            add("neighbourhood", "Centro");
            add("city", "Amparo");
            add("state", "SP");
            add("country", "Brasil");
            add("zipcode", "13900020");
            add("latitude", -22.7027179);
            add("longitude", -46.7642695);
        }});

        Fixture.of(EnderecoEntity.class).addTemplate(TEMPLATE_VALIDO_ENDERECO_TO_UPDATE, new Rule(){{
            add("streetName", "Washington Luís");
            add("number", 120);
            add("complement", "casa");
            add("neighbourhood", "Centro");
            add("city", "Amparo");
            add("state", "SP");
            add("country", "Brasil");
            add("zipcode", "13900020");
            add("latitude", -22.80);
            add("longitude", -45.20);
        }});

        Fixture.of(EnderecoEntity.class).addTemplate(TEMPLATE_VALIDO_ENDERECO_UPDATED, new Rule(){{
            add("id", 1L);
            add("streetName", "Washington Luís");
            add("number", 120);
            add("complement", "casa");
            add("neighbourhood", "Centro");
            add("city", "Amparo");
            add("state", "SP");
            add("country", "Brasil");
            add("zipcode", "13900020");
            add("latitude", -22.80);
            add("longitude", -45.20);
        }});


    }
}
