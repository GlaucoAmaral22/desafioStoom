package com.desafioStoom.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.desafioStoom.integration.googleGeocoding.SaidaGeoCoding;

public class LocationTemplate implements TemplateLoader {

    public static final String TEMPLATE_VALIDO_LOCATION = "Location Valid";
    public static final String TEMPLATE_VALIDO_NEW_LOCATION = "New Location Valid";


    @Override
    public void load() {
        Fixture.of(SaidaGeoCoding.Location.class).addTemplate(TEMPLATE_VALIDO_LOCATION, new Rule(){{
            add("lat", -22.7027179);
            add("lng", -46.7642695);
        }});

        Fixture.of(SaidaGeoCoding.Location.class).addTemplate(TEMPLATE_VALIDO_NEW_LOCATION, new Rule(){{
            add("lat", -22.80);
            add("lng", -45.20);
        }});

    }
}
