/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package RESTClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:MyRestResource [myRest]<br>
 * USAGE:
 * <pre>
 *        empClient client = new empClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Vijay Rana
 */
public class MyRestCli {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080";

    public MyRestCli() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }

//    public void updateDepartment(String deptId) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("updateDept/{0}", new Object[]{deptId})).request().post(null);
//    }
//
//    public void putJson(Object requestEntity) throws ClientErrorException {
//        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public void deleteEmp(String empId) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("deleteEmployee/{0}", new Object[]{empId})).request().delete();
//    }
//
//    public void deleteDept(String deptId) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("deleteDept/{0}", new Object[]{deptId})).request().delete();
//    }
//
//    public <T> T getEmployeeList(Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getEmps");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getEmpById(Class<T> responseType, String empId) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(java.text.MessageFormat.format("getEmp/{0}", new Object[]{empId}));
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getDepartments(Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getDepartments");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void updateEmp(Object requestEntity, String empId, String deptId) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("updateEmployee/{0}/{1}", new Object[]{empId, deptId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//    public void addEmployee(Object requestEntity, String deptId) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("contact");
//        webTarget.path(java.text.MessageFormat.format("sendMessage/{0}", new Object[]{deptId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//    
    public void sendMessage(Object requestEntity) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("contact/sendMessage");
        resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getSubscription(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("subscription/getSubscriptions");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }

}
