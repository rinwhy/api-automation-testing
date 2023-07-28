package com.solvd.carina.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "https://api.${base_url}/objects/${id}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/objects/_put/rq.json")
@ResponseTemplatePath(path = "api/objects/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateObjectMethod extends AbstractApiMethodV2 {

    public UpdateObjectMethod(String id) {
        replaceUrlPlaceholder("base_url",Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("id", id);
    }

}
