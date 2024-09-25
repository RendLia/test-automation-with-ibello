package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.model.Case;
import ibello.steps.CasesSteps;
import ibello.steps.LoginSteps;

@Name("Cases")
public class CasesWorkflow extends StepLibrary {

    private CasesSteps casesSteps;
    private Case caseData;
    private LoginSteps loginSteps;
    private int casesCount;

    public void a_felhasználó_az_új_ügy_rögzítési_felületen_van() {
        loginSteps.login_to_cases_page();
        casesSteps.create_new_case();
        casesSteps.new_case_page_is_loaded();
    }

    public void a_felhasználó_kitöltötte_az_összes_adatot() {
        caseData = testData().fromJson(Case.class).withId("tomorrow").load();
        casesSteps.fill_all_field_with_$_data(caseData);
    }

    public void a_felhasználó_a_holnapi_napot_adja_meg_érvényességi_időnek() {
        output().recordCustomAction("Az előző lépésben helyes tesztadat lett átadva ");
    }

    public void a_felhasználó_elmenti_az_új_ügyet() {
        casesSteps.save_case();
    }

    public void a_felhasználó_visszatér_az_ügyek_oldalra() {
        casesSteps.cases_page_is_loaded();
    }

    public void az_új_ügy_egyedi_azonosítóval_megjelenik_az_ügyek_táblázatban() {
        casesSteps.assume_that_case_appears_in_table(caseData);
        casesSteps.assume_that_new_id_appears();
    }

    public void legalább_egy_ügy_van_a_rendszerben() {
        casesCount = 4;
        caseData = testData().fromJson(Case.class).withId("1").load();
    }

    public void a_felhasználó_az_ügyek_oldalon_van() {
        loginSteps.login_to_cases_page();
    }

    public void a_felhasználó_ellenőrzi_a_megjelent_ügyek_adatait() {
        output().recordCustomAction("Az automatának itt nem kell semmit csinálnia");
    }

    public void minden_ügy_megjelenik_egy_táblában() {
        casesSteps.expect_that_table_has_$_number_of_cases(casesCount);
    }

    public void megjelenik_az_ügy_azonosítója() {
        casesSteps.assume_that_case_appears_in_table(caseData);
    }

    public void megjelenik_az_ügy_állapota() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_megnevezése() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_személye() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_érvényessége() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_felelőse() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void a_felhasználó_kezdeményezi_egy_új_ügy_létrehozását() {
        casesSteps.create_new_case();
    }

    public void az_új_ügy_oldal_megjelenik() {
        casesSteps.new_case_page_is_loaded();
    }

    public void az_ügy_állapota_új() {
        casesSteps.case_status_should_be_new();
    }

    public void az_állapot_nem_szerkeszthető() {
        casesSteps.status_should_be_readonly();
    }

    public void az_ügy_felelőse_ki_van_töltve() {
        casesSteps.responsible_should_be_not_empty();
    }

    public void a_felhasználó_megszakítja_az_ügy_létrehozását() {
        casesSteps.cancel_case_creation();
    }

    public void új_ügy_nem_jelenik_meg_a_listában() {
        casesCount = 4;
        casesSteps.expect_that_table_has_$_number_of_cases(casesCount);
    }

    public void a_felhasználó_megnyitja_szerkesztésre_az_ügyet() {
        caseData = testData().fromJson(Case.class).withId("1").load();
        casesSteps.open_case_with_$_id(caseData.getId());
    }

    public void a_felhasználó_az_ügy_oldalára_jut() {
        casesSteps.edit_form_case_is_loaded();
    }

    public void az_ügy_azonosítója_megjelenik() {
        casesSteps.assume_that_$_id_is_on_case_form(caseData.getId());
    }

    public void az_ügy_felelőse_megjelenik() {
        casesSteps.responsible_should_be_not_empty();// "tartalom"(value) validáció
    }

    public void a_két_érték_nem_módosítható() {
        casesSteps.responsible_is_not_editable();
        output().recordCustomAction("Az adat a fejlécben van így nem szerkeszthető");
    }

    public void a_felhasználó_egy_meglévő_ügy_oldalán_van() {
        caseData = testData().fromJson(Case.class).withId("1").load();
        loginSteps.login_to_cases_page();
        casesSteps.open_case_with_$_id(caseData.getId());
        casesSteps.edit_form_case_is_loaded();
    }

    public void a_felhasználó_módosítja_az_ügy_alapadatait() {
        Case edit = testData().fromJson(Case.class).withId("modification").load();
        casesSteps.fill_default_field_to_$(edit.getDefaultData());
    }

    public void az_ügy_módosítás_nélkül_jelenik_meg() {
        casesSteps.assume_that_case_appears_in_table(caseData);
    }

    public void a_felhasználó_módosítja_az_ügy_cím_adatait() {
        Case edit = testData().fromJson(Case.class).withId("modification").load();
        casesSteps.fill_address_field_to_$(edit.getAddress());
    }

    public void a_felhasználó_elmenti_az_ügyet() {
        casesSteps.save_case();
    }

    public void az_ügy_módosításai_megjelenek_az_ügyek_táblázatban() {
        Case edit = testData().fromJson(Case.class).withId("modification").load();
        casesSteps.assume_that_case_appears_in_table(edit);
    }

    //átmozgatva a loginStepsbe
  /*  @Internal //az ibello nem tekinti tesztlépésnek, viszont a riportba bekerül
    public void navigate_to_cases_page() {
        loginSteps.open_demo_application();
        loginSteps.login_with_valid_user();
    }*/
}
