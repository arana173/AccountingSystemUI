/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFCdiBeans;

import Entities.BusinessMaster;
import Entities.Contact;
import Entities.Country;
import Entities.DepartmentMaster;
import Entities.EmployeeMaster;
import Entities.ReportType;
import Entities.SourceDocumentType;
import Entities.Subscription;
import Entities.UserMaster;
import Entities.VoucherType;
import HelperClasses.responseClass;
import RestClient.RestClient;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

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
    List<UserMaster> users;
    GenericType<responseClass<List<UserMaster>>> genUserList;
    responseClass<List<UserMaster>> userres;

    //Display Source Document
    List<SourceDocumentType> source_doceMasters;
    GenericType<responseClass<List<SourceDocumentType>>> gen_src_doc_types;
    responseClass<List<SourceDocumentType>> res_src_doc;
    SourceDocumentType save_source_DocumentType;

    //Display Voucher Type 
    List<VoucherType> voucherTypes_list;
    GenericType<responseClass<List<VoucherType>>> gen_voucherType;
    responseClass<List<VoucherType>> res_voucher_type;
    VoucherType save_voucher_Type;

    //Display Report Type 
    List<ReportType> reporttype_List;
    GenericType<responseClass<List<ReportType>>> gen_reportType;
    responseClass<List<ReportType>> res_report_type;
    ReportType save_report_Type;

    //Display Departments
    List<DepartmentMaster> department_List;
    GenericType<responseClass<List<DepartmentMaster>>> gen_department_masterType;
    responseClass<List<DepartmentMaster>> res_department_master;
    DepartmentMaster save_deparDepartmentMaster;
    DepartmentMaster selectedDepartment;

    //Display Employee
    List<EmployeeMaster> employee_List;
    GenericType<responseClass<List<EmployeeMaster>>> gen_EmployeeMaster;
    responseClass<List<EmployeeMaster>> res_Employee_master;
    EmployeeMaster save_EmployeeMaster;

    //Display Business
    List<BusinessMaster> businessMasters_list;
    GenericType<responseClass<List<BusinessMaster>>> gen_BusinessMaster;
    responseClass<List<BusinessMaster>> res_Business_master;
    BusinessMaster save_BusinessMaster;
    BusinessMaster selectedBussines;

    public DepartmentMaster getSelectedDepartment() {
        return selectedDepartment;
    }

    public void setSelectedDepartment(DepartmentMaster selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public BusinessMaster getSelectedBussines() {
        return selectedBussines;
    }

    public void setSelectedBussines(BusinessMaster selectedBussines) {
        System.out.println(" Selected Business Is  " + selectedBussines.getBusinessTitle());

        this.selectedBussines = selectedBussines;
    }

    public List<DepartmentMaster> GetDepartmentByName() {

        return null;
    }

    public List<BusinessMaster> getBusinessMasters_list() {
        return businessMasters_list;
    }

    public void setBusinessMasters_list(List<BusinessMaster> businessMasters_list) {
        this.businessMasters_list = businessMasters_list;
    }

    public BusinessMaster getSave_BusinessMaster() {
        return save_BusinessMaster;
    }

    public void setSave_BusinessMaster(BusinessMaster save_BusinessMaster) {
        this.save_BusinessMaster = save_BusinessMaster;
    }

    public List<EmployeeMaster> getEmployee_List() {
        return employee_List;
    }

    public void setEmployee_List(List<EmployeeMaster> employee_List) {
        this.employee_List = employee_List;
    }

    public EmployeeMaster getSave_EmployeeMaster() {
        return save_EmployeeMaster;
    }

    public void setSave_EmployeeMaster(EmployeeMaster save_EmployeeMaster) {
        this.save_EmployeeMaster = save_EmployeeMaster;
    }

    public List<DepartmentMaster> getDepartment_List() {
        return department_List;
    }

    public void setDepartment_List(List<DepartmentMaster> department_List) {
        this.department_List = department_List;
    }

    public List<ReportType> getReporttype_List() {
        return reporttype_List;
    }

    public void setReporttype_List(List<ReportType> reporttype_List) {
        this.reporttype_List = reporttype_List;
    }

    public ReportType getSave_report_Type() {
        return save_report_Type;
    }

    public void setSave_report_Type(ReportType save_report_Type) {
        this.save_report_Type = save_report_Type;
    }

    public SourceDocumentType getSave_source_DocumentType() {
        return save_source_DocumentType;
    }

    public void setSave_source_DocumentType(SourceDocumentType save_source_DocumentType) {
        System.out.println("Hello " + save_source_DocumentType.getTitle());
        this.save_source_DocumentType = save_source_DocumentType;
    }

    public List<VoucherType> getVoucherTypes_list() {
        return voucherTypes_list;
    }

    public void setVoucherTypes_list(List<VoucherType> voucherTypes_list) {
        this.voucherTypes_list = voucherTypes_list;
    }

    public VoucherType getSave_voucher_Type() {
        return save_voucher_Type;
    }

    public void setSave_voucher_Type(VoucherType save_voucher_Type) {
        this.save_voucher_Type = save_voucher_Type;
    }

    //Manage Country
    responseClass<List<Country>> countryRes;
    GenericType<responseClass<List<Country>>> genCountryRes;
    List<Country> countries;
    List<Country> selectedCountries;
    Country selectedCountry;

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
        genUserList = new GenericType<responseClass<List<UserMaster>>>() {
        };
        userres = new responseClass<List<UserMaster>>();

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
        //Voucher Type
        voucherTypes_list = new ArrayList<VoucherType>();
        gen_voucherType = new GenericType<responseClass<List<VoucherType>>>() {
        };
        res_voucher_type = new responseClass<List<VoucherType>>();
        save_voucher_Type = new VoucherType();

        source_doceMasters = new ArrayList<SourceDocumentType>();
        gen_src_doc_types = new GenericType<responseClass<List<SourceDocumentType>>>() {
        };
        res_src_doc = new responseClass<List<SourceDocumentType>>();
        save_source_DocumentType = new SourceDocumentType();

        reporttype_List = new ArrayList<ReportType>();
        gen_reportType = new GenericType<responseClass<List<ReportType>>>() {
        };
        res_report_type = new responseClass<List<ReportType>>();
        save_report_Type = new ReportType();

        department_List = new ArrayList<DepartmentMaster>();
        gen_department_masterType = new GenericType<responseClass<List<DepartmentMaster>>>() {
        };
        res_department_master = new responseClass<List<DepartmentMaster>>();
        save_deparDepartmentMaster = new DepartmentMaster();

        employee_List = new ArrayList<EmployeeMaster>();
        gen_EmployeeMaster = new GenericType<responseClass<List<EmployeeMaster>>>() {
        };
        res_Employee_master = new responseClass<List<EmployeeMaster>>();
        save_EmployeeMaster = new EmployeeMaster();

        //Display Business
        businessMasters_list = new ArrayList<BusinessMaster>();
        gen_BusinessMaster = new GenericType<responseClass<List<BusinessMaster>>>() {
        };
        res_Business_master = new responseClass<List<BusinessMaster>>();
        save_BusinessMaster = new BusinessMaster();

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

    public List<Country> DisplayCountries() {
        response = client.getAllCountries(Response.class);
        countryRes = response.readEntity(genCountryRes);
        countries = countryRes.getData();
        return countries;
    }

    public List<UserMaster> DisplayUserList() {
        response = client.getallUser(Response.class);
        userres = response.readEntity(genUserList);
        users = userres.getData();
        return users;
    }
    //Manage Country Start

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

    public void openNew2() {
        this.save_source_DocumentType = new SourceDocumentType();
        this.save_voucher_Type = new VoucherType();
        this.save_report_Type = new ReportType();
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

    //============================================Manage Source Document Type =====================================================
    public List<SourceDocumentType> DisplaySrcDocumentList() {
        response = client.getallSource_Document(Response.class);
        res_src_doc = response.readEntity(gen_src_doc_types);
        source_doceMasters = res_src_doc.getData();
        return source_doceMasters;
    }

    public void savesource_document() {
        if (this.save_source_DocumentType.getSrcDocumentTypeId() == null) {
            System.out.println("id is  null " + this.save_source_DocumentType.getTitle());
            this.save_source_DocumentType.setSrcDocumentTypeId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
            response = client.add_src_doc(this.save_source_DocumentType, Response.class);
            responseCls = response.readEntity(genResponseCls);
            System.out.println(responseCls.getData() + "    " + responseCls.getStatus() + "  " + responseCls.getStatusCode());
            if (responseCls.getData() == true) {
                this.source_doceMasters.add(this.save_source_DocumentType);
                PrimeFaces.current().executeScript("PF('managesrcDialog').hide()");
                PrimeFaces.current().ajax().update("form:messages", "form:dt-products");

            }

        } else {
            System.out.println("Id is " + save_source_DocumentType.getSrcDocumentTypeId() + " Name is " + save_source_DocumentType.getTitle());
            response = client.update_src_doc(this.save_source_DocumentType, this.save_source_DocumentType.getSrcDocumentTypeId(), Response.class);
            responseCls = response.readEntity(genResponseCls);
            if (responseCls.getData() == true) {
                // this.source_doceMasters.add(this.save_source_DocumentType);
                PrimeFaces.current().executeScript("PF('managesrcDialog').hide()");
                PrimeFaces.current().ajax().update("form:messages", "form:dt-products");

            }
            this.save_source_DocumentType = null;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Source Document Updated "));
        }
    }

    public void deleteSource_src_doc() {
        System.out.println("deleted data  " + save_source_DocumentType.getSrcDocumentTypeId() + save_source_DocumentType.getTitle());
        response = client.deleteSrc_doc(save_source_DocumentType.getSrcDocumentTypeId(), Response.class);
        responseCls = response.readEntity(genResponseCls);
        System.out.println(responseCls.getStatus() + responseCls.getStatusCode());
        if ("OK".equals(responseCls.getStatus())) {
            this.source_doceMasters.remove(this.save_source_DocumentType);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Source Document Removed"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        }
    }

    //Manage Voucher Type start
    public List<VoucherType> DisplayVoucher_type() {
        response = client.getAllVoucherType(Response.class);
        res_voucher_type = response.readEntity(gen_voucherType);
        voucherTypes_list = res_voucher_type.getData();
        return voucherTypes_list;
    }

    public void save_voucherType() {
        if (this.save_voucher_Type.getVoucherTypeId() == null) {
            System.out.println("id is  null " + this.save_voucher_Type.getVoucherTypeName());
            this.save_voucher_Type.setVoucherTypeId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
            response = client.add_voucher_type(this.save_voucher_Type, Response.class);
            responseCls = response.readEntity(genResponseCls);
            System.out.println(responseCls.getData() + "    " + responseCls.getStatus() + "  " + responseCls.getStatusCode());
            if (responseCls.getData() == true) {
                this.voucherTypes_list.add(this.save_voucher_Type);
                PrimeFaces.current().executeScript("PF('managesrcDialog').hide()");
                PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
            }

        } else {
            System.out.println("Id is " + save_voucher_Type.getVoucherTypeId() + " Name is " + save_voucher_Type.getVoucherTypeName());
            response = client.editvoucher_type(this.save_voucher_Type, this.save_voucher_Type.getVoucherTypeId(), Response.class);
            responseCls = response.readEntity(genResponseCls);
            System.out.println(responseCls.getData() + responseCls.getErrors() + responseCls.getMessage());
//            if (responseCls.getData() == true) {
//                // this.source_doceMasters.add(this.save_source_DocumentType);
//                PrimeFaces.current().executeScript("PF('managesrcDialog').hide()");
//                PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Source Document Updated "));
//                this.save_voucher_Type = null;
//            }
        }

    }

    public void deletevoucherType() {
        System.out.println("deleted data  " + save_voucher_Type.getVoucherTypeName() + save_voucher_Type.getVoucherTypeId());
        response = client.delete_voucherType(save_voucher_Type.getVoucherTypeId(), Response.class);
        responseCls = response.readEntity(genResponseCls);
        System.out.println(responseCls.getStatus() + responseCls.getStatusCode());
        if ("OK".equals(responseCls.getStatus())) {
            this.voucherTypes_list.remove(this.save_voucher_Type);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Voucher Type Removed"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        }

    }

    //================================================Report Type ===================================================================
    public List<ReportType> DisplayActiveReportTypes() {
        response = client.getAllReportTYpe(Response.class);
        res_report_type = response.readEntity(gen_reportType);
        reporttype_List = res_report_type.getData();
        List<ReportType> activeReports = new ArrayList<>();
        for (int i = 0; i < reporttype_List.size(); i++) {
            if (reporttype_List.get(i).getActive()) {
                activeReports.add(reporttype_List.get(i));
            }
        }
        return activeReports;
    }

    public List<ReportType> DisplayUnActiveReportTypes() {
        response = client.getAllReportTYpe(Response.class);
        res_report_type = response.readEntity(gen_reportType);
        reporttype_List = res_report_type.getData();
        List<ReportType> activeReports = new ArrayList<>();
        for (int i = 0; i < reporttype_List.size(); i++) {
            if (reporttype_List.get(i).getActive() == false) {
                activeReports.add(reporttype_List.get(i));
            }
        }
        return activeReports;
    }

    public void savereport_type() {
        if (this.save_report_Type.getReportTypeId() == null) {
            System.out.println("id is  null " + this.save_report_Type.getReportTypeName());
            this.save_report_Type.setReportTypeId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
            this.save_report_Type.setActive(true);
            response = client.add_report_type(this.save_report_Type, Response.class);
            responseCls = response.readEntity(genResponseCls);
            System.out.println(responseCls.getData() + "    " + responseCls.getStatus() + "  " + responseCls.getStatusCode());
            if (responseCls.getData() == true) {
                this.reporttype_List.add(this.save_report_Type);
                PrimeFaces.current().executeScript("PF('managesrcDialog').hide()");
                PrimeFaces.current().ajax().update("form:messages", "form:dt-report");

            }

        } else {
            System.out.println("Id is " + save_report_Type.getReportTypeId() + " Name is " + save_report_Type.getReportTypeName());
            response = client.update_report_type(this.save_report_Type, this.save_report_Type.getReportTypeId(), Response.class);
            responseCls = response.readEntity(genResponseCls);
            if (responseCls.getData() == true) {
                // this.source_doceMasters.add(this.save_source_DocumentType);
                PrimeFaces.current().executeScript("PF('managesrcDialog').hide()");
                PrimeFaces.current().ajax().update("form:messages", "form:dt-report");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Source Document Updated "));
            }
            this.save_report_Type = null;
        }
    }

    public void deleteReport_type() {
        System.out.println("deleted data  " + save_report_Type.getReportTypeId() + save_report_Type.getReportTypeName());
        response = client.deleteReport_Type(save_report_Type.getReportTypeId(), Response.class);
        responseCls = response.readEntity(genResponseCls);
        System.out.println(responseCls.getStatus() + responseCls.getStatusCode() + res_report_type.getErrors() + responseCls.getMessage());
        if ("OK".equals(responseCls.getStatus())) {
            this.reporttype_List.remove(this.save_report_Type);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Report Type Removed"));
            UIComponent baseComponent = FacesContext.getCurrentInstance().getViewRoot();
            UIComponent datatable = findComponentById(baseComponent, "dt-unactivereports");
            PrimeFaces.current().ajax().update(datatable.getClientId());
            datatable = findComponentById(baseComponent, "dt-report");
            PrimeFaces.current().ajax().update(datatable.getClientId());
        }
    }
    private boolean unactive = true;

    public boolean isUnactive() {
        return unactive;
    }

    public void setUnactive(boolean unactive) {
        this.unactive = unactive;
    }

    public void handleToggleChange(ReportType report) {
        report.setActive(unactive);
        System.out.println(" active is " + report.getActive() + report.getReportTypeId() + report.getReportTypeName());

        response = client.deleteReport_Type(report.getReportTypeId(), Response.class);
        responseCls = response.readEntity(genResponseCls);
        System.out.println(responseCls.getStatus() + responseCls.getStatusCode() + res_report_type.getErrors() + responseCls.getMessage());
        this.unactive = true;

        UIComponent baseComponent = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent datatable = findComponentById(baseComponent, "dt-unactivereports");
        PrimeFaces.current().ajax().update(datatable.getClientId());
        datatable = findComponentById(baseComponent, "dt-report");
        PrimeFaces.current().ajax().update(datatable.getClientId());
    }

    public UIComponent findComponentById(UIComponent base, String Id) {
        if (Id.equals(base.getId())) {
            return base;
        } else {
            Iterator<UIComponent> children = base.getFacetsAndChildren();
            while (children.hasNext()) {
                UIComponent child = children.next();
                UIComponent foundComponent = findComponentById(child, Id);
                if (foundComponent != null) {
                    return foundComponent;
                }
            }
            return null;
        }
    }

    public List<DepartmentMaster> DisplayDepartmentsData() {
        response = client.getallDepartments(Response.class);
        res_department_master = response.readEntity(gen_department_masterType);
        department_List = res_department_master.getData();

//        for(int i =0;i<department_List.size();i++)
//        {
//            System.out.println(department_List.get(i).getBranch().getBranchId());
//        }
        return department_List;
    }

    public List<EmployeeMaster> DisplayAllEmployee() {
        response = client.getAllEmployee(Response.class);
        res_Employee_master = response.readEntity(gen_EmployeeMaster);
        employee_List = res_Employee_master.getData();

//        for (int i = 0; i < department_List.size(); i++) {
//            System.out.println(department_List.get(i).getBranch().getBranchId());
//        }
        return employee_List;
    }

    public List<BusinessMaster> DiplayAllBussiness() {
        response = client.getallBusinessMaster(Response.class);
        res_Business_master = response.readEntity(gen_BusinessMaster);
        businessMasters_list = res_Business_master.getData();

        return businessMasters_list;
    }

    private boolean showTable;

    public boolean isShowTable() {
        return showTable;
    }

    public void setShowTable(boolean showTable) {
        this.showTable = showTable;
    }

    public void showDataTable() {
        showTable = true;
    }

//    
//    
//    public void openLevel1() {
//        Map<String, Object> options = new HashMap<String, Object>();
//        options.put("modal", true);
//        PrimeFaces.current().dialog().openDynamic("level1", options, null);
//    }
//
//    public void openLevel1WithFlash() {
//        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("param1", LocalDateTime.now());
//        openLevel1();
//    }
//
//    public void onReturnFromLevel1(SelectEvent event) {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
//    }
}
