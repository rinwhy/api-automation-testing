package API;
import com.solvd.apiTesting.GetAllObjectsMethod;
import com.solvd.apiTesting.GetSingleObjectMethod;
import com.solvd.apiTesting.PostObjectMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITesting {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "Rin")
    public void testGetAllObjects() {
        GetAllObjectsMethod api = new GetAllObjectsMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/objects/_get/_allObjects/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Rin")
    public void testGetSingleObject() {
        GetSingleObjectMethod api = new GetSingleObjectMethod(3);
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/objects/_get/singleObject/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Rin")
    public void postObject() {
        PostObjectMethod api = new PostObjectMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();

    }



}
