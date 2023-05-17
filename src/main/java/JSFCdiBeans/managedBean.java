/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFCdiBeans;

import Entities.Contact;
import Entities.Country;
import Entities.ReportType;
import Entities.Subscription;
import Entities.UserMaster;
import Entities.VoucherType;
import HelperClasses.responseClass;
import RestClient.RestClient;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Vijay Rana
 */
@Named(value = "manageData")
@SessionScoped
public class managedBean implements Serializable {

    /**
     * Creates a new instance of managedBean
     */
    //Response Class Object
    responseClass<Boolean> responseCls;
    GenericType<responseClass<Boolean>> genResponseCls;

    //manages contact/feedback
    Contact contact;

    //shows subscriptions
    List<Subscription> subscriptions;
    GenericType<List<Subscription>> genSubscriptionList;
    List<String> features;

    //Display Users
    //shows subscriptions
    List<UserMaster> users;
    GenericType<List<UserMaster>> genUserList;

    //Manage Country
    responseClass<List<Country>> countryRes;
    GenericType<responseClass<List<Country>>> genCountryRes;
    List<Country> countries;
    List<Country> selectedCountries;
    Country selectedCountry;

    //Manage Report Types
    List<ReportType> reportTypes;
    GenericType<List<ReportType>> genReportTypeList;
    List<ReportType> selectedReportTypes;
    ReportType selectedReportType;

    //Manage Report Types
    List<VoucherType> voucherTypes;
    GenericType<List<VoucherType>> genVoucherTypeList;
    List<VoucherType> selectedVoucherTypes;
    VoucherType selectedVoucherType;

    public List<Country> getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(List<Country> selectedCountries) {
        this.selectedCountries = selectedCountries;
    }

    public Country getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(Country selectedCountry) {
        System.out.println("Hello " + selectedCountry.getCountryName());
        this.selectedCountry = selectedCountry;
    }

    Response response;

    public List<UserMaster> getUsers() {
        return users;
    }

    public void setUsers(List<UserMaster> users) {
        this.users = users;
    }
    RestClient client;

    public managedBean() {
        contact = new Contact();
        client = new RestClient();
        genSubscriptionList = new GenericType<List<Subscription>>() {
        };

        //Response class
        responseCls = new responseClass<Boolean>();
        genResponseCls = new GenericType<responseClass<Boolean>>() {
        };

        //Users
        users = new ArrayList<UserMaster>();
        genUserList = new GenericType<List<UserMaster>>() {
        };

        //Subscription
        subscriptions = new ArrayList<Subscription>();
        features = new ArrayList<String>();

        //Country
        countryRes = new responseClass<List<Country>>();
        genCountryRes = new GenericType<responseClass<List<Country>>>() {
        };
        countries = new ArrayList<Country>();
        selectedCountries = new ArrayList<Country>();
        selectedCountry = new Country();

        //Report Type
        reportTypes = new ArrayList<ReportType>();
        selectedReportTypes = new ArrayList<ReportType>();
        selectedReportType = new ReportType();
        genReportTypeList = new GenericType<List<ReportType>>() {
        };

        //Voucher Type
        voucherTypes = new ArrayList<VoucherType>();
        selectedVoucherTypes = new ArrayList<VoucherType>();
        selectedVoucherType = new VoucherType();
        genVoucherTypeList = new GenericType<List<VoucherType>>() {
        };

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
        //client.sendMessage(contact);
        System.out.println(contact.getContactId() + "  " + contact.getEmail() + "  " + contact.getFirstname() + "  " + contact.getLastname()
                + "     " + contact.getTitle() + "     " + contact.getMessage());
    }

    public List<String> displayFeatures(Subscription sub) {
        features = Arrays.asList(sub.getFeatures().split(";"));
        //features = Arrays.asList(subscriptions.get(pos).getFeatures().toString().split(";"));
        return features;
    }

//    public List<UserMaster> DisplayUsers() {
//        response = client.getallUser(Response.class);
//        users = response.readEntity(genUserList);
//        System.out.println(users);
//        return (List<UserMaster>) users;
//    }
    //Manage Country Start
    public List<Country> DisplayCountries() {
        response = client.getAllCountries(Response.class);
        countryRes = response.readEntity(genCountryRes);
        countries = countryRes.getData();
        return countries;
    }

    public boolean hasSelectedCountry() {
        return this.selectedCountries != null && !this.selectedCountries.isEmpty();
    }

    public String getDeleteBtnMessage() {
        if (hasSelectedCountry()) {
            int size = this.selectedCountries.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }
        return "Delete";
    }

    public void deleteSelectedCountries() {
//        this.products.removeAll(this.selectedProducts);
//        this.selectedProducts = null;
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
//        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

    public void deleteSelectedCountry() {
        response = client.deleteCountry(selectedCountry.getCountryId(), Response.class);
        responseCls = response.readEntity(genResponseCls);
        System.out.println(responseCls.getStatus() + responseCls.getStatusCode());
        this.countries.remove(this.selectedCountry);
        this.selectedCountries.remove(this.selectedCountry);
        this.selectedCountry = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void openNew() {
        this.selectedCountry = new Country();
    }

    public void saveCountry() {
        if (this.selectedCountry.getCountryId() == null) {
            this.selectedCountry.setCountryId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
            response = client.addCountry(this.selectedCountry, Response.class);
            responseCls = response.readEntity(genResponseCls);
            System.out.println(responseCls.getData() + "    " + responseCls.getStatus() + "  " + responseCls.getStatusCode());
            this.countries.add(this.selectedCountry);
            this.selectedCountry = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Country Added"));
        } else {
            response = client.updateCountry(this.selectedCountry, this.selectedCountry.getCountryId(), Response.class);
            responseCls = response.readEntity(genResponseCls);
            this.selectedCountry = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Country Updated"));
        }
        
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
    //Manage Country End

    //Manage Report Types start
    public List<ReportType> DisplayReportType() {
        response = client.getAllReportTypes(Response.class);
        reportTypes = response.readEntity(genReportTypeList);
        return reportTypes;
    }
    //Manage report Types end

    //Manage Voucher Type start
    public List<VoucherType> DisplayVoucherType() {
        response = client.getAllReportTypes(Response.class);
        voucherTypes = response.readEntity(genVoucherTypeList);
        return voucherTypes;
    }
    //Manage Voucher Type end
}
