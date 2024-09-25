package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.steps.StepLibrary;
import ibello.model.Address;
import ibello.model.Case;
import ibello.model.DefaultData;
import ibello.pages.CasesPage;
import ibello.pages.CasesTable;
import ibello.pages.EditCaseFormPage;
import ibello.pages.NewCaseFormPage;

import java.time.LocalDate;

@Name("Cases steps")
public class CasesSteps extends StepLibrary {

    private CasesPage casesPage;
    private NewCaseFormPage newCaseFormPage;
    private EditCaseFormPage editCaseFormPage;
    private CasesTable casesTable;

    // Oldalbetöltést validáló metódusok
    public void new_case_page_is_loaded() {
        newCaseFormPage.page_must_be_loaded();
    }

    public void cases_page_is_loaded() {
        casesPage.page_must_be_loaded();
    }

    public void edit_form_case_is_loaded() {
        editCaseFormPage.page_must_be_loaded();
    }

    //ügyek oldalhoz kapcsolódó metódusok

    public void create_new_case() {
        casesPage.click_on_new_case_button();
    }

    public void expect_that_table_has_$_number_of_cases(int count) {
        casesTable.expect_that_table_has_$_number_of_cases(count);
    }

    //Új ügyekhez kapcsolódó metódusok
    public void fill_all_field_with_$_data(Case data) {
        if (data != null){
            DefaultData defaultData = data.getDefaultData();
            if (defaultData != null) {
                fill_default_field_to_$(defaultData);
            }
            Address address = data.getAddress();
            if (address != null){
                fill_address_field_to_$(address);
            }
        } else {
            throw new TestException("Az ügy adatait tartalmazó teszt adat fájl üres volt");
        }
    }

    public void save_case() {
        newCaseFormPage.click_on_save_button();
    }

    public void case_status_should_be_new() {
        newCaseFormPage.assume_that_status_is_$("Új");
    }

    public void status_should_be_readonly() {
        newCaseFormPage.assume_that_status_is_editable();
    }

    public void responsible_should_be_not_empty() {
        newCaseFormPage.assume_that_responsible_field_is_not_empty();
    }

    public void cancel_case_creation() {
        newCaseFormPage.click_on_cancel_button();
    }

    public void assume_that_case_appears_in_table(Case data) {
        if (data != null){
            String id = data.getId();
            if (id != null) {
                casesTable.assume_that_id_in_last_row_is_$(id);
            }
            String status = data.getStatus();
            if (status != null) {
                casesTable.assume_that_status_in_last_row_is_$(status);
            }
            String casename = data.getDefaultData().getCasename();
            if (casename != null) {
               casesTable.assume_that_case_name_in_last_row_is_$(casename);
            }
            LocalDate validity = data.getDefaultData().getValidity();
            if (validity != null) {
                casesTable.assume_that_validity_in_last_row_is_$(validity);
            }
            String person = data.getDefaultData().getPerson();
            if (person != null) {
                casesTable.assume_that_person_in_last_row_is_$(person);
            }
            String responsible = data.getResponsible();
            if (responsible != null) {
                casesTable.assume_that_responsible_in_last_row_is_$(responsible);
            }
        } else {
            throw new TestException("Az ügy adatait tartalmazó teszt adat fájl üres volt");
        }
    }

    public void assume_that_new_id_appears() {
        casesTable.assume_that_last_row_has_id();
    }

    //Szerkesztésre megnyitott ügy
    public void assume_that_$_id_is_on_case_form(String id) {
        editCaseFormPage.assume_that_title_contains_$_id(id);
    }

    public void responsible_is_not_editable(){
        editCaseFormPage.assume_that_responsible_is_readonly();
    }
    public void fill_default_field_to_$(DefaultData dd) { //kell egy változó teszt adat fájl
        if (dd !=null){
            String name = dd.getCasename();
            if (name != null) {
                editCaseFormPage.set_casename_to_$(name);
            }
            LocalDate validity = dd.getValidity();
            if (validity != null) {
                editCaseFormPage.set_valitity_to_$(validity);
            }
            String person = dd.getPerson();
            if (person != null) {
                editCaseFormPage.set_person_to_$(person);
            } else {
                throw new TestException("Az alapadatokat tartalmazó teszt adat fájl üres volt");
            }
        }
    }
    public void fill_address_field_to_$(Address ad) {
        if ( ad !=null){
            String city = ad.getCity();
            if (city != null) {
                editCaseFormPage.set_city_to_$(city);
            }
            int zipcode = ad.getZipCode();
            if (zipcode != 0) {
                editCaseFormPage.set_zipcode_to_$(zipcode);
            }
            String street = ad.getStreet();
            if (street != null) {
                editCaseFormPage.set_street_to_$(street);
            }
            String number = ad.getNumber();
            if (number != null) {
                editCaseFormPage.set_number_to_$(number);
            }
        } else {
            throw new TestException("A címet tartalmazó teszt adat fájl üres volt");
        }
    }

    public void open_case_with_$_id(String id) {
        casesTable.click_on_case_with_$_id(id);
    }


}
