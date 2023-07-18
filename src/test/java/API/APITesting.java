package API;
import com.solvd.apiTesting.*;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APITesting {

    @Test(testName = "Get All Objects")
    @MethodOwner(owner = "Rin")
    public void testGetAllObjects() {
        GetAllObjectsMethod api = new GetAllObjectsMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/objects/_get/allObjects/rs.schema");
    }

    @Test(testName = "Get Object")
    @MethodOwner(owner = "Rin")
    public void testGetSingleObject() {
        GetSingleObjectMethod api = new GetSingleObjectMethod("3");
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/objects/_get/singleObject/rs.schema");
    }

    @Test(testName = "Post Object")
    @MethodOwner(owner = "Rin")
    public void postObject() {
        PostObjectMethod api = new PostObjectMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }


    @Test(testName = "Updating an Object")
    @MethodOwner(owner = "Rin")
    public void updateObject() {
        UpdateObjectMethod api = new UpdateObjectMethod("ff8081818958b0d30189667cf1a70a62");
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(testName = "Patching Object Name")
    @MethodOwner(owner = "Rin")
    public void patchObjectName() {
        PatchObjectNameMethod api   = new PatchObjectNameMethod("ff8081818958b0d30189667cf1a70a62");
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }


    @Test(testName = "Patching Object Data")
    @MethodOwner(owner = "Rin")
    public void patchObjectData() {
        PatchObjectDataMethod api = new PatchObjectDataMethod("ff8081818958b0d30189667cf1a70a62");
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }


    @Test(testName = "Delete Object")
    @MethodOwner(owner = "Rin")
    public void deleteObject() {
        DeleteObjectMethod api = new DeleteObjectMethod("ff8081818958b0d30189666c26150a5a");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}
