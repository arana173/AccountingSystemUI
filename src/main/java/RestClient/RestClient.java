/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package RestClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:userRest [user]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author 57ren
 */
public class RestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }

    public <T> T sendMessage(Object requestEntity,Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("contact/sendMessage");
        return webTarget.path("contact/sendMessage").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON),responseType);
    }

    public <T> T getSubscription(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("subscription/getSubscriptions");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getallSource_Document(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Admin/getAllSource_Document_Type");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    //Country Start 
    //get all countries
    public <T> T getAllCountries(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("country/getCountries");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    //Add Country
    public <T> T addCountry(Object requestEntity,Class<T> responseType) throws ClientErrorException {
       return webTarget.path("country/addCountry").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON),responseType);
    }

    //delete Country
    public <T> T deleteCountry(String countryId,Class<T> responseType) throws ClientErrorException {
      return webTarget.path(java.text.MessageFormat.format("country/toggleCountry/{0}", new Object[]{countryId})).request().delete(responseType);
    }
    
    //Update Country
    public <T> T updateCountry(Object requestEntity,String countryId,Class<T> responseType) throws ClientErrorException {
       return webTarget.path(java.text.MessageFormat.format("country/updateCountry/{0}", new Object[]{countryId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON),responseType);
    }
    //Country End
    //Users Start
    //Get All users
    public <T> T getallUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("admin/getallUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    //Users End
    //Subscriptions Start
    //get all subscription
    public <T> T getAllSubscriptions(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("subscription/getSubscriptions");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    //Add Subscription
    public void addSubscription(Object requestEntity) throws ClientErrorException {
        webTarget.path("subscription/addSubscription").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    //delete Subscription
    public void deleteSubscription(String countryId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("subscription/deleteSubscription/{0}", new Object[]{countryId})).request().delete();
    }
    //Subscriptions End
    
        //Country Start 
    //get all countries
    public <T> T getAllReportTypes(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("reportType/getReportTypes");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    //Add Country
    public void addReportType(Object requestEntity) throws ClientErrorException {
        webTarget.path("reportType/addReportType").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    //delete Country
    public void deleteReportType(String countryId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("reportType/deleteReportType/{0}", new Object[]{countryId})).request().delete();
    }
    //Country End
    
    
    
//    public <T> T getUserByuName(Class<T> responseType, String name) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(java.text.MessageFormat.format("getUserByName/{0}", new Object[]{name}));
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getUserById(Class<T> responseType, String id) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(java.text.MessageFormat.format("getUserById/{0}", new Object[]{id}));
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public String deleteEmp(String id, String userid) throws ClientErrorException {
//        return webTarget.path(java.text.MessageFormat.format("removeEmp/{0}/{1}", new Object[]{id, userid})).request().delete(String.class);
//    }
//
//    public <T> T getAllusername(Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllUsername");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public String deleteUser(String id) throws ClientErrorException {
//        return webTarget.path(java.text.MessageFormat.format("removeUser/{0}", new Object[]{id})).request().delete(String.class);
//    }
//
//    public void editUser(Object requestEntity, String id) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("editUser/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public void updateUser(String uname, String add, String gen, String hob, String userid) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}", new Object[]{uname, add, gen, hob, userid})).request().put(null);
//    }
//
//    public <T> T saveEmp(Class<T> responseType, String EmpName, String Userid) throws ClientErrorException {
//        return webTarget.path(java.text.MessageFormat.format("saveEmp/{0}/{1}", new Object[]{EmpName, Userid})).request().post(null, responseType);
//    }
//
//    public <T> T updateEmp(Object requestEntity, Class<T> responseType, String empname, String Empid, String userid) throws ClientErrorException {
//        return webTarget.path(java.text.MessageFormat.format("updateEmp/{0}/{1}/{2}", new Object[]{empname, Empid, userid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
//    }
//
//    public void saveUser(String uname, String add, String gen, String hob) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}", new Object[]{uname, add, gen, hob})).request().post(null);
//    }
//
//    public <T> T getAllEmployees(Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllEmp");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
    public void close() {
        client.close();
    }

}
