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
    private static final String BASE_URI = "http://localhost:8090/";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }

    public <T> T sendMessage(Object requestEntity, Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("contact/sendMessage");
        return webTarget.path("contact/sendMessage").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
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
    public <T> T addCountry(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("country/addCountry").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T add_src_doc(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("Admin/addSource_Document_Type").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    //delete Country
    public <T> T deleteCountry(String countryId, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("country/toggleCountry/{0}", new Object[]{countryId})).request().delete(responseType);
    }

    //Update Country
    public <T> T updateCountry(Object requestEntity, String countryId, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("country/updateCountry/{0}", new Object[]{countryId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
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

    public <T> T update_src_doc(Object requestEntity, String countryId, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("Admin/editSource_Document_Type/{0}", new Object[]{countryId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T deleteSrc_doc(String source_doc_id, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("Admin/deleteSource_Document_Type/{0}", new Object[]{source_doc_id})).request().delete(responseType);
    }
    //Country End

    public <T> T getAllVoucherType(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Admin/getAllVoucherType");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T add_voucher_type(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("Admin/addVoucherTypetype").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

//    public <T> T update_voucher_type(Object requestEntity, String voucherId, Class<T> responseType) throws ClientErrorException {
//        return webTarget.path(java.text.MessageFormat.format("Admin/editVoucherType/{0}", new Object[]{voucherId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
//    }
    public <T> T editvoucher_type(Object requestEntity, String voucherId, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("Admin/editVoucherType/{0}", new Object[]{voucherId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T delete_voucherType(String voucherId, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("/Admin/deleteVoucherType/{0}", new Object[]{voucherId})).request().delete(responseType);
    }

    public void close() {
        client.close();
    }

    public <T> T getAllReportTYpe(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("reportType/getReportTypes");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T add_report_type(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("reportType/addReportType").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T update_report_type(Object requestEntity, String reportID, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("reportType/updateReportType/{0}", new Object[]{reportID})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T deleteReport_Type(String source_doc_id, Class<T> responseType) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("reportType/deleteReportType/{0}", new Object[]{source_doc_id})).request().delete(responseType);

    }

    public <T> T getallDepartments(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("department/getDepartments");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
}
