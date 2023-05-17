/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFCdiBeans.UserCdi;

import Entities.Contact;
import Entities.Subscription;
import HelperClasses.responseClass;
import RestClient.RestClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vijay Rana
 */
@Named(value = "subsMsgBean")
@Dependent
public class subsMsgBean {

    //Rest Client
    RestClient restCli;

    //Response 
    Response response;

    //Manage Subscriptions
    List<Subscription> subscriptions;
    responseClass<List<Subscription>> subsResponse;
    GenericType<responseClass<List<Subscription>>> genSubsResponse;
    List<String> features;

    //Manage Messages
    Contact contact;
    responseClass<Boolean> contactResponse;
    GenericType<responseClass<Boolean>> genContactResponse;

    public List<Subscription> getSubscriptions() {
        response = restCli.getAllSubscriptions(Response.class);
        subsResponse = response.readEntity(genSubsResponse);
        this.subscriptions = subsResponse.getData();
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * Creates a new instance of subsMsgBean
     */
    public subsMsgBean() {
        restCli = new RestClient();
        subscriptions = new ArrayList<Subscription>();
        subsResponse = new responseClass<List<Subscription>>();
        genSubsResponse = new GenericType<responseClass<List<Subscription>>>() {
        };
        contact = new Contact();
        features = new ArrayList<String>();
    }

    public void sendMessage() {
        response = restCli.sendMessage(contact, Response.class);
        contactResponse = response.readEntity(genContactResponse);
        System.out.println(contactResponse.getData() + "     " + contactResponse.getStatus() + contactResponse.getStatusCode());
    }

    public List<String> displayFeatures(Subscription sub) {
        features = Arrays.asList(sub.getFeatures().split(";"));
        //features = Arrays.asList(subscriptions.get(pos).getFeatures().toString().split(";"));
        return features;
    }

}
