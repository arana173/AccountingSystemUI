/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFCdiBeans;

import Entities.Contact;
import Entities.Subscription;
import RESTClient.MyRestCli;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vijay Rana
 */
@Named(value = "managedBean")
@SessionScoped
public class managedBean implements Serializable {

    /**
     * Creates a new instance of managedBean
     */
    
    //manages contact/feedback
    Contact contact;

    //shows subscriptions
    List<Subscription> subscriptions;
    GenericType<List<Subscription>> genSubscriptionList;
    List<String> features;
    
    Response response;
    MyRestCli client;

    public managedBean() {
        contact = new Contact();
        client = new MyRestCli();
        genSubscriptionList = new GenericType<List<Subscription>>(){};
        subscriptions = new ArrayList<Subscription>();
        features = new ArrayList<String>();
    }

    public List<Subscription> getSubscriptions() {
        response = client.getSubscription(Response.class);
        subscriptions = response.readEntity(genSubscriptionList);
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

    public void sendMessage() {
        contact.setContactId("contact001");
        client.sendMessage(contact);
        System.out.println(contact.getContactId() + "  " + contact.getEmail() + "  " + contact.getFirstname() + "  " + contact.getLastname()
                + "     " + contact.getTitle() + "     " + contact.getMessage());
    }
    
    public List<String> displayFeatures(Subscription sub)
    {
        features = Arrays.asList(sub.getFeatures().split(";"));
        //features = Arrays.asList(subscriptions.get(pos).getFeatures().toString().split(";"));
        return features;
    }
}
