
package feukora.webservice.rmi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the feukora.webservice.rmi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindMessungByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMessungByIdResponse");
    private final static QName _FindAllBrenner_QNAME = new QName("http://rmi.webservice.feukora/", "findAllBrenner");
    private final static QName _UpdateKontaktResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateKontaktResponse");
    private final static QName _FindMitarbeiterByNameResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByNameResponse");
    private final static QName _UpdateAuftrag_QNAME = new QName("http://rmi.webservice.feukora/", "updateAuftrag");
    private final static QName _UpdateWaermeerzeuger_QNAME = new QName("http://rmi.webservice.feukora/", "updateWaermeerzeuger");
    private final static QName _FindFeuerungsanlageByWaermeerzeuger_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageByWaermeerzeuger");
    private final static QName _FindBrennerByBaujahrResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerByBaujahrResponse");
    private final static QName _FindMitarbeiterByArbeitetBis_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByArbeitetBis");
    private final static QName _FindAllFeuerungsanlage_QNAME = new QName("http://rmi.webservice.feukora/", "findAllFeuerungsanlage");
    private final static QName _FindFeuerungsanlageByBrenner_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageByBrenner");
    private final static QName _FindBenutzerByUsernameResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findBenutzerByUsernameResponse");
    private final static QName _FindLiegenschaftByOrt_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftByOrt");
    private final static QName _FindAuftragByKontaktResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByKontaktResponse");
    private final static QName _AddMitarbeiterResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addMitarbeiterResponse");
    private final static QName _FindMitarbeiterByVornameResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByVornameResponse");
    private final static QName _FindAuftragByDatumResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByDatumResponse");
    private final static QName _FindAuftragByLiegenschaftResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByLiegenschaftResponse");
    private final static QName _AddFeuerungsanlageResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addFeuerungsanlageResponse");
    private final static QName _FindWaermeerzeugerByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerByIdResponse");
    private final static QName _FindBrennerByArtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerByArtResponse");
    private final static QName _FindAuftragByDateAndMitarbeiterResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByDateAndMitarbeiterResponse");
    private final static QName _FindAllAuftragResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllAuftragResponse");
    private final static QName _AddBrenner_QNAME = new QName("http://rmi.webservice.feukora/", "addBrenner");
    private final static QName _FindMitarbeiterByRolleIntern_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByRolleIntern");
    private final static QName _FindAuftragByAuftragsNummer_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByAuftragsNummer");
    private final static QName _FindWaermeerzeugerByBrennstoff_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerByBrennstoff");
    private final static QName _FindBenutzerByUsername_QNAME = new QName("http://rmi.webservice.feukora/", "findBenutzerByUsername");
    private final static QName _FindMitarbeiterByNameVorname_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByNameVorname");
    private final static QName _FindWaermeerzeugerById_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerById");
    private final static QName _UpdateFeuerungsanlage_QNAME = new QName("http://rmi.webservice.feukora/", "updateFeuerungsanlage");
    private final static QName _FindFeuerungsanlageByLiegenschaft_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageByLiegenschaft");
    private final static QName _DeleteLiegenschaft_QNAME = new QName("http://rmi.webservice.feukora/", "deleteLiegenschaft");
    private final static QName _FindAllLiegenschaft_QNAME = new QName("http://rmi.webservice.feukora/", "findAllLiegenschaft");
    private final static QName _DeleteAuftragResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteAuftragResponse");
    private final static QName _DeleteLiegenschaftById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteLiegenschaftById");
    private final static QName _DeleteAuftrag_QNAME = new QName("http://rmi.webservice.feukora/", "deleteAuftrag");
    private final static QName _DeleteAuftragById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteAuftragById");
    private final static QName _UpdateMessungResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateMessungResponse");
    private final static QName _FindWaermeerzeugerByBrennstoffResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerByBrennstoffResponse");
    private final static QName _FindAllMitarbeiter_QNAME = new QName("http://rmi.webservice.feukora/", "findAllMitarbeiter");
    private final static QName _FindKontaktById_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktById");
    private final static QName _FindKontaktByRolleExternResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByRolleExternResponse");
    private final static QName _DeleteBenutzerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteBenutzerResponse");
    private final static QName _FindOrtByOrtBez_QNAME = new QName("http://rmi.webservice.feukora/", "findOrtByOrtBez");
    private final static QName _FindAuftragByAuftragsNummerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByAuftragsNummerResponse");
    private final static QName _FindLiegenschaftByKontaktResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftByKontaktResponse");
    private final static QName _FindMitarbeiterByBenutzerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByBenutzerResponse");
    private final static QName _FindLiegenschaftByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftByIdResponse");
    private final static QName _DeleteMessungResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMessungResponse");
    private final static QName _AddBrennerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addBrennerResponse");
    private final static QName _DeleteAuftragByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteAuftragByIdResponse");
    private final static QName _FindKontaktByNameResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByNameResponse");
    private final static QName _FindOrtByOrtBezResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findOrtByOrtBezResponse");
    private final static QName _FindBrennerByTypResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerByTypResponse");
    private final static QName _FindOrtById_QNAME = new QName("http://rmi.webservice.feukora/", "findOrtById");
    private final static QName _FindMitarbeiterByBenutzer_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByBenutzer");
    private final static QName _DeleteWaermeerzeugerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteWaermeerzeugerResponse");
    private final static QName _DeleteMitarbeiter_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMitarbeiter");
    private final static QName _AddBenutzer_QNAME = new QName("http://rmi.webservice.feukora/", "addBenutzer");
    private final static QName _DeleteKontaktResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteKontaktResponse");
    private final static QName _UpdateBrennerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateBrennerResponse");
    private final static QName _FindMessungByDatum_QNAME = new QName("http://rmi.webservice.feukora/", "findMessungByDatum");
    private final static QName _FindAllMitarbeiterResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllMitarbeiterResponse");
    private final static QName _FindAuftragByLiegenschaft_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByLiegenschaft");
    private final static QName _FindMessungByBeurteilungNotOk_QNAME = new QName("http://rmi.webservice.feukora/", "findMessungByBeurteilungNotOk");
    private final static QName _FindLiegenschaftByKontakt_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftByKontakt");
    private final static QName _FindAuftragByMitarbeiter_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByMitarbeiter");
    private final static QName _FindMitarbeiterByNameVornameResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByNameVornameResponse");
    private final static QName _FindMitarbeiterByOrt_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByOrt");
    private final static QName _UpdateBenutzerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateBenutzerResponse");
    private final static QName _FindKontaktByOrt_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByOrt");
    private final static QName _AddAuftrag_QNAME = new QName("http://rmi.webservice.feukora/", "addAuftrag");
    private final static QName _FindMitarbeiterByStrasse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByStrasse");
    private final static QName _FindMitarbeiterByVorname_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByVorname");
    private final static QName _DeleteWaermeerzeuger_QNAME = new QName("http://rmi.webservice.feukora/", "deleteWaermeerzeuger");
    private final static QName _FindAllKontakte_QNAME = new QName("http://rmi.webservice.feukora/", "findAllKontakte");
    private final static QName _FindFeuerungsanlageByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageByIdResponse");
    private final static QName _AddKontakt_QNAME = new QName("http://rmi.webservice.feukora/", "addKontakt");
    private final static QName _FindAuftragByKontakt_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByKontakt");
    private final static QName _DeleteOrtById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteOrtById");
    private final static QName _UpdateKontakt_QNAME = new QName("http://rmi.webservice.feukora/", "updateKontakt");
    private final static QName _UpdateBenutzer_QNAME = new QName("http://rmi.webservice.feukora/", "updateBenutzer");
    private final static QName _FindKontaktByOrtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByOrtResponse");
    private final static QName _FindAllKontakteResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllKontakteResponse");
    private final static QName _FindFeuerungsanlageById_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageById");
    private final static QName _AddMessung_QNAME = new QName("http://rmi.webservice.feukora/", "addMessung");
    private final static QName _FindAllMessungResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllMessungResponse");
    private final static QName _DeleteFeuerungsanlage_QNAME = new QName("http://rmi.webservice.feukora/", "deleteFeuerungsanlage");
    private final static QName _FindAllKontaktResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllKontaktResponse");
    private final static QName _FindAllLiegenschaftResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllLiegenschaftResponse");
    private final static QName _UpdateOrt_QNAME = new QName("http://rmi.webservice.feukora/", "updateOrt");
    private final static QName _FindBrennerByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerByIdResponse");
    private final static QName _FindAllAuftrag_QNAME = new QName("http://rmi.webservice.feukora/", "findAllAuftrag");
    private final static QName _FindMitarbeiterByArbeitetSeitResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByArbeitetSeitResponse");
    private final static QName _DeleteMitarbeiterByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMitarbeiterByIdResponse");
    private final static QName _AddWaermeerzeuger_QNAME = new QName("http://rmi.webservice.feukora/", "addWaermeerzeuger");
    private final static QName _FindAllFeuerungsanlageResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllFeuerungsanlageResponse");
    private final static QName _FindKontaktByVorname_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByVorname");
    private final static QName _UpdateOrtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateOrtResponse");
    private final static QName _FindBenutzerByUsernamePasswordResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findBenutzerByUsernamePasswordResponse");
    private final static QName _FindAllBenutzerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllBenutzerResponse");
    private final static QName _AddLiegenschaft_QNAME = new QName("http://rmi.webservice.feukora/", "addLiegenschaft");
    private final static QName _DeleteKontakt_QNAME = new QName("http://rmi.webservice.feukora/", "deleteKontakt");
    private final static QName _FindFeuerungsanlageByWaermeerzeugerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageByWaermeerzeugerResponse");
    private final static QName _FindAuftragByMitarbeiterResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByMitarbeiterResponse");
    private final static QName _FindBrennerById_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerById");
    private final static QName _DeleteKontaktById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteKontaktById");
    private final static QName _AddKontaktResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addKontaktResponse");
    private final static QName _DeleteLiegenschaftByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteLiegenschaftByIdResponse");
    private final static QName _FindBrennerByBaujahr_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerByBaujahr");
    private final static QName _FindBenutzerByUsernamePassword_QNAME = new QName("http://rmi.webservice.feukora/", "findBenutzerByUsernamePassword");
    private final static QName _UpdateMitarbeiterResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateMitarbeiterResponse");
    private final static QName _FindOrtByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findOrtByIdResponse");
    private final static QName _DeleteMessung_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMessung");
    private final static QName _FindAuftragByDatum_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByDatum");
    private final static QName _FindLiegenschaftByStrasse_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftByStrasse");
    private final static QName _UpdateMitarbeiter_QNAME = new QName("http://rmi.webservice.feukora/", "updateMitarbeiter");
    private final static QName _AddAuftragResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addAuftragResponse");
    private final static QName _FindFeuerungsanlageByLiegenschaftResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageByLiegenschaftResponse");
    private final static QName _DeleteFeuerungsanlageResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteFeuerungsanlageResponse");
    private final static QName _FindKontaktByVornameResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByVornameResponse");
    private final static QName _DeleteBrennerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteBrennerResponse");
    private final static QName _FindAllBenutzer_QNAME = new QName("http://rmi.webservice.feukora/", "findAllBenutzer");
    private final static QName _FindWaermeerzeugerByBaujahr_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerByBaujahr");
    private final static QName _AddMitarbeiter_QNAME = new QName("http://rmi.webservice.feukora/", "addMitarbeiter");
    private final static QName _FindMessungById_QNAME = new QName("http://rmi.webservice.feukora/", "findMessungById");
    private final static QName _FindAllBrennerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllBrennerResponse");
    private final static QName _DeleteOrtByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteOrtByIdResponse");
    private final static QName _UpdateMessung_QNAME = new QName("http://rmi.webservice.feukora/", "updateMessung");
    private final static QName _DeleteMitarbeiterResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMitarbeiterResponse");
    private final static QName _DeleteWaermeerzeugerById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteWaermeerzeugerById");
    private final static QName _UpdateWaermeerzeugerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateWaermeerzeugerResponse");
    private final static QName _FindLiegenschaftByOrtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftByOrtResponse");
    private final static QName _DeleteKontaktByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteKontaktByIdResponse");
    private final static QName _FindAllWaermeerzeuger_QNAME = new QName("http://rmi.webservice.feukora/", "findAllWaermeerzeuger");
    private final static QName _FindMitarbeiterById_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterById");
    private final static QName _AddLiegenschaftResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addLiegenschaftResponse");
    private final static QName _FindOrtByPlz_QNAME = new QName("http://rmi.webservice.feukora/", "findOrtByPlz");
    private final static QName _FindKontaktByStrasseResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByStrasseResponse");
    private final static QName _FindWaermeerzeugerByBaujahrResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerByBaujahrResponse");
    private final static QName _FindBenutzerById_QNAME = new QName("http://rmi.webservice.feukora/", "findBenutzerById");
    private final static QName _FindBenutzerByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findBenutzerByIdResponse");
    private final static QName _FindLiegenschaftByStrasseResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftByStrasseResponse");
    private final static QName _FindKontaktByRolleExtern_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByRolleExtern");
    private final static QName _FindMitarbeiterByArbeitetBisResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByArbeitetBisResponse");
    private final static QName _DeleteBenutzer_QNAME = new QName("http://rmi.webservice.feukora/", "deleteBenutzer");
    private final static QName _DeleteBrennerById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteBrennerById");
    private final static QName _FindKontaktByStrasse_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByStrasse");
    private final static QName _FindWaermeerzeugerByTyp_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerByTyp");
    private final static QName _FindFeuerungsanlageByBrennerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findFeuerungsanlageByBrennerResponse");
    private final static QName _UpdateFeuerungsanlageResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateFeuerungsanlageResponse");
    private final static QName _FindAllMessung_QNAME = new QName("http://rmi.webservice.feukora/", "findAllMessung");
    private final static QName _FindMitarbeiterByArbeitetSeit_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByArbeitetSeit");
    private final static QName _AddBenutzerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addBenutzerResponse");
    private final static QName _DeleteOrt_QNAME = new QName("http://rmi.webservice.feukora/", "deleteOrt");
    private final static QName _AddFeuerungsanlage_QNAME = new QName("http://rmi.webservice.feukora/", "addFeuerungsanlage");
    private final static QName _FindKontaktByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByIdResponse");
    private final static QName _FindMitarbeiterByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByIdResponse");
    private final static QName _FindMitarbeiterByStrasseResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByStrasseResponse");
    private final static QName _Exception_QNAME = new QName("http://rmi.webservice.feukora/", "Exception");
    private final static QName _DeleteBrenner_QNAME = new QName("http://rmi.webservice.feukora/", "deleteBrenner");
    private final static QName _DeleteOrtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteOrtResponse");
    private final static QName _FindLiegenschaftById_QNAME = new QName("http://rmi.webservice.feukora/", "findLiegenschaftById");
    private final static QName _FindMitarbeiterByName_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByName");
    private final static QName _FindMessungByBeurteilungNotOkResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMessungByBeurteilungNotOkResponse");
    private final static QName _AddWaermeerzeugerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addWaermeerzeugerResponse");
    private final static QName _DeleteMitarbeiterById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMitarbeiterById");
    private final static QName _FindMessungByDatumResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMessungByDatumResponse");
    private final static QName _DeleteMessungByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMessungByIdResponse");
    private final static QName _DeleteLiegenschaftResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteLiegenschaftResponse");
    private final static QName _FindWaermeerzeugerByTypResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findWaermeerzeugerByTypResponse");
    private final static QName _FindOrtByPlzResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findOrtByPlzResponse");
    private final static QName _DeleteMessungById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteMessungById");
    private final static QName _DeleteFeuerungsanlageByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteFeuerungsanlageByIdResponse");
    private final static QName _FindAllWaermeerzeugerResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllWaermeerzeugerResponse");
    private final static QName _AddMessungResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addMessungResponse");
    private final static QName _DeleteBrennerByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteBrennerByIdResponse");
    private final static QName _UpdatLiegenschaftResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updatLiegenschaftResponse");
    private final static QName _AddOrtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "addOrtResponse");
    private final static QName _DeleteWaermeerzeugerByIdResponse_QNAME = new QName("http://rmi.webservice.feukora/", "deleteWaermeerzeugerByIdResponse");
    private final static QName _FindAllOrtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findAllOrtResponse");
    private final static QName _UpdatLiegenschaft_QNAME = new QName("http://rmi.webservice.feukora/", "updatLiegenschaft");
    private final static QName _FindBrennerByArt_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerByArt");
    private final static QName _DeleteFeuerungsanlageById_QNAME = new QName("http://rmi.webservice.feukora/", "deleteFeuerungsanlageById");
    private final static QName _AddOrt_QNAME = new QName("http://rmi.webservice.feukora/", "addOrt");
    private final static QName _FindKontaktByName_QNAME = new QName("http://rmi.webservice.feukora/", "findKontaktByName");
    private final static QName _FindMitarbeiterByRolleInternResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByRolleInternResponse");
    private final static QName _FindMitarbeiterByOrtResponse_QNAME = new QName("http://rmi.webservice.feukora/", "findMitarbeiterByOrtResponse");
    private final static QName _FindAllOrt_QNAME = new QName("http://rmi.webservice.feukora/", "findAllOrt");
    private final static QName _FindBrennerByTyp_QNAME = new QName("http://rmi.webservice.feukora/", "findBrennerByTyp");
    private final static QName _UpdateBrenner_QNAME = new QName("http://rmi.webservice.feukora/", "updateBrenner");
    private final static QName _FindAuftragByDateAndMitarbeiter_QNAME = new QName("http://rmi.webservice.feukora/", "findAuftragByDateAndMitarbeiter");
    private final static QName _FindAllKontakt_QNAME = new QName("http://rmi.webservice.feukora/", "findAllKontakt");
    private final static QName _UpdateAuftragResponse_QNAME = new QName("http://rmi.webservice.feukora/", "updateAuftragResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: feukora.webservice.rmi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindMitarbeiterByRolleIntern }
     * 
     */
    public FindMitarbeiterByRolleIntern createFindMitarbeiterByRolleIntern() {
        return new FindMitarbeiterByRolleIntern();
    }

    /**
     * Create an instance of {@link FindAllAuftragResponse }
     * 
     */
    public FindAllAuftragResponse createFindAllAuftragResponse() {
        return new FindAllAuftragResponse();
    }

    /**
     * Create an instance of {@link FindAuftragByDateAndMitarbeiterResponse }
     * 
     */
    public FindAuftragByDateAndMitarbeiterResponse createFindAuftragByDateAndMitarbeiterResponse() {
        return new FindAuftragByDateAndMitarbeiterResponse();
    }

    /**
     * Create an instance of {@link AddBrenner }
     * 
     */
    public AddBrenner createAddBrenner() {
        return new AddBrenner();
    }

    /**
     * Create an instance of {@link FindBrennerByArtResponse }
     * 
     */
    public FindBrennerByArtResponse createFindBrennerByArtResponse() {
        return new FindBrennerByArtResponse();
    }

    /**
     * Create an instance of {@link DeleteLiegenschaftById }
     * 
     */
    public DeleteLiegenschaftById createDeleteLiegenschaftById() {
        return new DeleteLiegenschaftById();
    }

    /**
     * Create an instance of {@link DeleteLiegenschaft }
     * 
     */
    public DeleteLiegenschaft createDeleteLiegenschaft() {
        return new DeleteLiegenschaft();
    }

    /**
     * Create an instance of {@link DeleteAuftragResponse }
     * 
     */
    public DeleteAuftragResponse createDeleteAuftragResponse() {
        return new DeleteAuftragResponse();
    }

    /**
     * Create an instance of {@link FindAllLiegenschaft }
     * 
     */
    public FindAllLiegenschaft createFindAllLiegenschaft() {
        return new FindAllLiegenschaft();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByNameVorname }
     * 
     */
    public FindMitarbeiterByNameVorname createFindMitarbeiterByNameVorname() {
        return new FindMitarbeiterByNameVorname();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerById }
     * 
     */
    public FindWaermeerzeugerById createFindWaermeerzeugerById() {
        return new FindWaermeerzeugerById();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageByLiegenschaft }
     * 
     */
    public FindFeuerungsanlageByLiegenschaft createFindFeuerungsanlageByLiegenschaft() {
        return new FindFeuerungsanlageByLiegenschaft();
    }

    /**
     * Create an instance of {@link UpdateFeuerungsanlage }
     * 
     */
    public UpdateFeuerungsanlage createUpdateFeuerungsanlage() {
        return new UpdateFeuerungsanlage();
    }

    /**
     * Create an instance of {@link FindAuftragByAuftragsNummer }
     * 
     */
    public FindAuftragByAuftragsNummer createFindAuftragByAuftragsNummer() {
        return new FindAuftragByAuftragsNummer();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerByBrennstoff }
     * 
     */
    public FindWaermeerzeugerByBrennstoff createFindWaermeerzeugerByBrennstoff() {
        return new FindWaermeerzeugerByBrennstoff();
    }

    /**
     * Create an instance of {@link FindBenutzerByUsername }
     * 
     */
    public FindBenutzerByUsername createFindBenutzerByUsername() {
        return new FindBenutzerByUsername();
    }

    /**
     * Create an instance of {@link DeleteBenutzerResponse }
     * 
     */
    public DeleteBenutzerResponse createDeleteBenutzerResponse() {
        return new DeleteBenutzerResponse();
    }

    /**
     * Create an instance of {@link FindKontaktByRolleExternResponse }
     * 
     */
    public FindKontaktByRolleExternResponse createFindKontaktByRolleExternResponse() {
        return new FindKontaktByRolleExternResponse();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerByBrennstoffResponse }
     * 
     */
    public FindWaermeerzeugerByBrennstoffResponse createFindWaermeerzeugerByBrennstoffResponse() {
        return new FindWaermeerzeugerByBrennstoffResponse();
    }

    /**
     * Create an instance of {@link DeleteAuftrag }
     * 
     */
    public DeleteAuftrag createDeleteAuftrag() {
        return new DeleteAuftrag();
    }

    /**
     * Create an instance of {@link DeleteAuftragById }
     * 
     */
    public DeleteAuftragById createDeleteAuftragById() {
        return new DeleteAuftragById();
    }

    /**
     * Create an instance of {@link UpdateMessungResponse }
     * 
     */
    public UpdateMessungResponse createUpdateMessungResponse() {
        return new UpdateMessungResponse();
    }

    /**
     * Create an instance of {@link FindKontaktById }
     * 
     */
    public FindKontaktById createFindKontaktById() {
        return new FindKontaktById();
    }

    /**
     * Create an instance of {@link FindAllMitarbeiter }
     * 
     */
    public FindAllMitarbeiter createFindAllMitarbeiter() {
        return new FindAllMitarbeiter();
    }

    /**
     * Create an instance of {@link FindLiegenschaftByIdResponse }
     * 
     */
    public FindLiegenschaftByIdResponse createFindLiegenschaftByIdResponse() {
        return new FindLiegenschaftByIdResponse();
    }

    /**
     * Create an instance of {@link FindOrtByOrtBez }
     * 
     */
    public FindOrtByOrtBez createFindOrtByOrtBez() {
        return new FindOrtByOrtBez();
    }

    /**
     * Create an instance of {@link FindAuftragByAuftragsNummerResponse }
     * 
     */
    public FindAuftragByAuftragsNummerResponse createFindAuftragByAuftragsNummerResponse() {
        return new FindAuftragByAuftragsNummerResponse();
    }

    /**
     * Create an instance of {@link FindLiegenschaftByKontaktResponse }
     * 
     */
    public FindLiegenschaftByKontaktResponse createFindLiegenschaftByKontaktResponse() {
        return new FindLiegenschaftByKontaktResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByBenutzerResponse }
     * 
     */
    public FindMitarbeiterByBenutzerResponse createFindMitarbeiterByBenutzerResponse() {
        return new FindMitarbeiterByBenutzerResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByNameResponse }
     * 
     */
    public FindMitarbeiterByNameResponse createFindMitarbeiterByNameResponse() {
        return new FindMitarbeiterByNameResponse();
    }

    /**
     * Create an instance of {@link UpdateAuftrag }
     * 
     */
    public UpdateAuftrag createUpdateAuftrag() {
        return new UpdateAuftrag();
    }

    /**
     * Create an instance of {@link UpdateWaermeerzeuger }
     * 
     */
    public UpdateWaermeerzeuger createUpdateWaermeerzeuger() {
        return new UpdateWaermeerzeuger();
    }

    /**
     * Create an instance of {@link UpdateKontaktResponse }
     * 
     */
    public UpdateKontaktResponse createUpdateKontaktResponse() {
        return new UpdateKontaktResponse();
    }

    /**
     * Create an instance of {@link FindAllBrenner }
     * 
     */
    public FindAllBrenner createFindAllBrenner() {
        return new FindAllBrenner();
    }

    /**
     * Create an instance of {@link FindMessungByIdResponse }
     * 
     */
    public FindMessungByIdResponse createFindMessungByIdResponse() {
        return new FindMessungByIdResponse();
    }

    /**
     * Create an instance of {@link FindBrennerByBaujahrResponse }
     * 
     */
    public FindBrennerByBaujahrResponse createFindBrennerByBaujahrResponse() {
        return new FindBrennerByBaujahrResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByArbeitetBis }
     * 
     */
    public FindMitarbeiterByArbeitetBis createFindMitarbeiterByArbeitetBis() {
        return new FindMitarbeiterByArbeitetBis();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageByWaermeerzeuger }
     * 
     */
    public FindFeuerungsanlageByWaermeerzeuger createFindFeuerungsanlageByWaermeerzeuger() {
        return new FindFeuerungsanlageByWaermeerzeuger();
    }

    /**
     * Create an instance of {@link FindAuftragByKontaktResponse }
     * 
     */
    public FindAuftragByKontaktResponse createFindAuftragByKontaktResponse() {
        return new FindAuftragByKontaktResponse();
    }

    /**
     * Create an instance of {@link AddMitarbeiterResponse }
     * 
     */
    public AddMitarbeiterResponse createAddMitarbeiterResponse() {
        return new AddMitarbeiterResponse();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageByBrenner }
     * 
     */
    public FindFeuerungsanlageByBrenner createFindFeuerungsanlageByBrenner() {
        return new FindFeuerungsanlageByBrenner();
    }

    /**
     * Create an instance of {@link FindBenutzerByUsernameResponse }
     * 
     */
    public FindBenutzerByUsernameResponse createFindBenutzerByUsernameResponse() {
        return new FindBenutzerByUsernameResponse();
    }

    /**
     * Create an instance of {@link FindLiegenschaftByOrt }
     * 
     */
    public FindLiegenschaftByOrt createFindLiegenschaftByOrt() {
        return new FindLiegenschaftByOrt();
    }

    /**
     * Create an instance of {@link FindAllFeuerungsanlage }
     * 
     */
    public FindAllFeuerungsanlage createFindAllFeuerungsanlage() {
        return new FindAllFeuerungsanlage();
    }

    /**
     * Create an instance of {@link AddFeuerungsanlageResponse }
     * 
     */
    public AddFeuerungsanlageResponse createAddFeuerungsanlageResponse() {
        return new AddFeuerungsanlageResponse();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerByIdResponse }
     * 
     */
    public FindWaermeerzeugerByIdResponse createFindWaermeerzeugerByIdResponse() {
        return new FindWaermeerzeugerByIdResponse();
    }

    /**
     * Create an instance of {@link FindAuftragByDatumResponse }
     * 
     */
    public FindAuftragByDatumResponse createFindAuftragByDatumResponse() {
        return new FindAuftragByDatumResponse();
    }

    /**
     * Create an instance of {@link FindAuftragByLiegenschaftResponse }
     * 
     */
    public FindAuftragByLiegenschaftResponse createFindAuftragByLiegenschaftResponse() {
        return new FindAuftragByLiegenschaftResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByVornameResponse }
     * 
     */
    public FindMitarbeiterByVornameResponse createFindMitarbeiterByVornameResponse() {
        return new FindMitarbeiterByVornameResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByVorname }
     * 
     */
    public FindMitarbeiterByVorname createFindMitarbeiterByVorname() {
        return new FindMitarbeiterByVorname();
    }

    /**
     * Create an instance of {@link AddAuftrag }
     * 
     */
    public AddAuftrag createAddAuftrag() {
        return new AddAuftrag();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByStrasse }
     * 
     */
    public FindMitarbeiterByStrasse createFindMitarbeiterByStrasse() {
        return new FindMitarbeiterByStrasse();
    }

    /**
     * Create an instance of {@link DeleteWaermeerzeuger }
     * 
     */
    public DeleteWaermeerzeuger createDeleteWaermeerzeuger() {
        return new DeleteWaermeerzeuger();
    }

    /**
     * Create an instance of {@link FindKontaktByOrt }
     * 
     */
    public FindKontaktByOrt createFindKontaktByOrt() {
        return new FindKontaktByOrt();
    }

    /**
     * Create an instance of {@link UpdateBenutzerResponse }
     * 
     */
    public UpdateBenutzerResponse createUpdateBenutzerResponse() {
        return new UpdateBenutzerResponse();
    }

    /**
     * Create an instance of {@link DeleteOrtById }
     * 
     */
    public DeleteOrtById createDeleteOrtById() {
        return new DeleteOrtById();
    }

    /**
     * Create an instance of {@link FindAuftragByKontakt }
     * 
     */
    public FindAuftragByKontakt createFindAuftragByKontakt() {
        return new FindAuftragByKontakt();
    }

    /**
     * Create an instance of {@link AddKontakt }
     * 
     */
    public AddKontakt createAddKontakt() {
        return new AddKontakt();
    }

    /**
     * Create an instance of {@link FindAllKontakte }
     * 
     */
    public FindAllKontakte createFindAllKontakte() {
        return new FindAllKontakte();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageByIdResponse }
     * 
     */
    public FindFeuerungsanlageByIdResponse createFindFeuerungsanlageByIdResponse() {
        return new FindFeuerungsanlageByIdResponse();
    }

    /**
     * Create an instance of {@link FindAllKontakteResponse }
     * 
     */
    public FindAllKontakteResponse createFindAllKontakteResponse() {
        return new FindAllKontakteResponse();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageById }
     * 
     */
    public FindFeuerungsanlageById createFindFeuerungsanlageById() {
        return new FindFeuerungsanlageById();
    }

    /**
     * Create an instance of {@link UpdateBenutzer }
     * 
     */
    public UpdateBenutzer createUpdateBenutzer() {
        return new UpdateBenutzer();
    }

    /**
     * Create an instance of {@link FindKontaktByOrtResponse }
     * 
     */
    public FindKontaktByOrtResponse createFindKontaktByOrtResponse() {
        return new FindKontaktByOrtResponse();
    }

    /**
     * Create an instance of {@link UpdateKontakt }
     * 
     */
    public UpdateKontakt createUpdateKontakt() {
        return new UpdateKontakt();
    }

    /**
     * Create an instance of {@link AddWaermeerzeuger }
     * 
     */
    public AddWaermeerzeuger createAddWaermeerzeuger() {
        return new AddWaermeerzeuger();
    }

    /**
     * Create an instance of {@link DeleteMitarbeiterByIdResponse }
     * 
     */
    public DeleteMitarbeiterByIdResponse createDeleteMitarbeiterByIdResponse() {
        return new DeleteMitarbeiterByIdResponse();
    }

    /**
     * Create an instance of {@link FindAllAuftrag }
     * 
     */
    public FindAllAuftrag createFindAllAuftrag() {
        return new FindAllAuftrag();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByArbeitetSeitResponse }
     * 
     */
    public FindMitarbeiterByArbeitetSeitResponse createFindMitarbeiterByArbeitetSeitResponse() {
        return new FindMitarbeiterByArbeitetSeitResponse();
    }

    /**
     * Create an instance of {@link UpdateOrt }
     * 
     */
    public UpdateOrt createUpdateOrt() {
        return new UpdateOrt();
    }

    /**
     * Create an instance of {@link FindBrennerByIdResponse }
     * 
     */
    public FindBrennerByIdResponse createFindBrennerByIdResponse() {
        return new FindBrennerByIdResponse();
    }

    /**
     * Create an instance of {@link AddMessung }
     * 
     */
    public AddMessung createAddMessung() {
        return new AddMessung();
    }

    /**
     * Create an instance of {@link FindAllMessungResponse }
     * 
     */
    public FindAllMessungResponse createFindAllMessungResponse() {
        return new FindAllMessungResponse();
    }

    /**
     * Create an instance of {@link FindAllKontaktResponse }
     * 
     */
    public FindAllKontaktResponse createFindAllKontaktResponse() {
        return new FindAllKontaktResponse();
    }

    /**
     * Create an instance of {@link FindAllLiegenschaftResponse }
     * 
     */
    public FindAllLiegenschaftResponse createFindAllLiegenschaftResponse() {
        return new FindAllLiegenschaftResponse();
    }

    /**
     * Create an instance of {@link DeleteFeuerungsanlage }
     * 
     */
    public DeleteFeuerungsanlage createDeleteFeuerungsanlage() {
        return new DeleteFeuerungsanlage();
    }

    /**
     * Create an instance of {@link AddBrennerResponse }
     * 
     */
    public AddBrennerResponse createAddBrennerResponse() {
        return new AddBrennerResponse();
    }

    /**
     * Create an instance of {@link DeleteMessungResponse }
     * 
     */
    public DeleteMessungResponse createDeleteMessungResponse() {
        return new DeleteMessungResponse();
    }

    /**
     * Create an instance of {@link DeleteMitarbeiter }
     * 
     */
    public DeleteMitarbeiter createDeleteMitarbeiter() {
        return new DeleteMitarbeiter();
    }

    /**
     * Create an instance of {@link DeleteWaermeerzeugerResponse }
     * 
     */
    public DeleteWaermeerzeugerResponse createDeleteWaermeerzeugerResponse() {
        return new DeleteWaermeerzeugerResponse();
    }

    /**
     * Create an instance of {@link FindBrennerByTypResponse }
     * 
     */
    public FindBrennerByTypResponse createFindBrennerByTypResponse() {
        return new FindBrennerByTypResponse();
    }

    /**
     * Create an instance of {@link FindOrtById }
     * 
     */
    public FindOrtById createFindOrtById() {
        return new FindOrtById();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByBenutzer }
     * 
     */
    public FindMitarbeiterByBenutzer createFindMitarbeiterByBenutzer() {
        return new FindMitarbeiterByBenutzer();
    }

    /**
     * Create an instance of {@link FindKontaktByNameResponse }
     * 
     */
    public FindKontaktByNameResponse createFindKontaktByNameResponse() {
        return new FindKontaktByNameResponse();
    }

    /**
     * Create an instance of {@link DeleteAuftragByIdResponse }
     * 
     */
    public DeleteAuftragByIdResponse createDeleteAuftragByIdResponse() {
        return new DeleteAuftragByIdResponse();
    }

    /**
     * Create an instance of {@link FindOrtByOrtBezResponse }
     * 
     */
    public FindOrtByOrtBezResponse createFindOrtByOrtBezResponse() {
        return new FindOrtByOrtBezResponse();
    }

    /**
     * Create an instance of {@link FindLiegenschaftByKontakt }
     * 
     */
    public FindLiegenschaftByKontakt createFindLiegenschaftByKontakt() {
        return new FindLiegenschaftByKontakt();
    }

    /**
     * Create an instance of {@link FindMessungByDatum }
     * 
     */
    public FindMessungByDatum createFindMessungByDatum() {
        return new FindMessungByDatum();
    }

    /**
     * Create an instance of {@link FindAllMitarbeiterResponse }
     * 
     */
    public FindAllMitarbeiterResponse createFindAllMitarbeiterResponse() {
        return new FindAllMitarbeiterResponse();
    }

    /**
     * Create an instance of {@link FindAuftragByLiegenschaft }
     * 
     */
    public FindAuftragByLiegenschaft createFindAuftragByLiegenschaft() {
        return new FindAuftragByLiegenschaft();
    }

    /**
     * Create an instance of {@link FindMessungByBeurteilungNotOk }
     * 
     */
    public FindMessungByBeurteilungNotOk createFindMessungByBeurteilungNotOk() {
        return new FindMessungByBeurteilungNotOk();
    }

    /**
     * Create an instance of {@link AddBenutzer }
     * 
     */
    public AddBenutzer createAddBenutzer() {
        return new AddBenutzer();
    }

    /**
     * Create an instance of {@link DeleteKontaktResponse }
     * 
     */
    public DeleteKontaktResponse createDeleteKontaktResponse() {
        return new DeleteKontaktResponse();
    }

    /**
     * Create an instance of {@link UpdateBrennerResponse }
     * 
     */
    public UpdateBrennerResponse createUpdateBrennerResponse() {
        return new UpdateBrennerResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByOrt }
     * 
     */
    public FindMitarbeiterByOrt createFindMitarbeiterByOrt() {
        return new FindMitarbeiterByOrt();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByNameVornameResponse }
     * 
     */
    public FindMitarbeiterByNameVornameResponse createFindMitarbeiterByNameVornameResponse() {
        return new FindMitarbeiterByNameVornameResponse();
    }

    /**
     * Create an instance of {@link FindAuftragByMitarbeiter }
     * 
     */
    public FindAuftragByMitarbeiter createFindAuftragByMitarbeiter() {
        return new FindAuftragByMitarbeiter();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerByBaujahr }
     * 
     */
    public FindWaermeerzeugerByBaujahr createFindWaermeerzeugerByBaujahr() {
        return new FindWaermeerzeugerByBaujahr();
    }

    /**
     * Create an instance of {@link FindAllBenutzer }
     * 
     */
    public FindAllBenutzer createFindAllBenutzer() {
        return new FindAllBenutzer();
    }

    /**
     * Create an instance of {@link DeleteBrennerResponse }
     * 
     */
    public DeleteBrennerResponse createDeleteBrennerResponse() {
        return new DeleteBrennerResponse();
    }

    /**
     * Create an instance of {@link DeleteOrtByIdResponse }
     * 
     */
    public DeleteOrtByIdResponse createDeleteOrtByIdResponse() {
        return new DeleteOrtByIdResponse();
    }

    /**
     * Create an instance of {@link FindMessungById }
     * 
     */
    public FindMessungById createFindMessungById() {
        return new FindMessungById();
    }

    /**
     * Create an instance of {@link FindAllBrennerResponse }
     * 
     */
    public FindAllBrennerResponse createFindAllBrennerResponse() {
        return new FindAllBrennerResponse();
    }

    /**
     * Create an instance of {@link AddMitarbeiter }
     * 
     */
    public AddMitarbeiter createAddMitarbeiter() {
        return new AddMitarbeiter();
    }

    /**
     * Create an instance of {@link FindOrtByPlz }
     * 
     */
    public FindOrtByPlz createFindOrtByPlz() {
        return new FindOrtByPlz();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerByBaujahrResponse }
     * 
     */
    public FindWaermeerzeugerByBaujahrResponse createFindWaermeerzeugerByBaujahrResponse() {
        return new FindWaermeerzeugerByBaujahrResponse();
    }

    /**
     * Create an instance of {@link FindKontaktByStrasseResponse }
     * 
     */
    public FindKontaktByStrasseResponse createFindKontaktByStrasseResponse() {
        return new FindKontaktByStrasseResponse();
    }

    /**
     * Create an instance of {@link DeleteKontaktByIdResponse }
     * 
     */
    public DeleteKontaktByIdResponse createDeleteKontaktByIdResponse() {
        return new DeleteKontaktByIdResponse();
    }

    /**
     * Create an instance of {@link FindAllWaermeerzeuger }
     * 
     */
    public FindAllWaermeerzeuger createFindAllWaermeerzeuger() {
        return new FindAllWaermeerzeuger();
    }

    /**
     * Create an instance of {@link FindMitarbeiterById }
     * 
     */
    public FindMitarbeiterById createFindMitarbeiterById() {
        return new FindMitarbeiterById();
    }

    /**
     * Create an instance of {@link AddLiegenschaftResponse }
     * 
     */
    public AddLiegenschaftResponse createAddLiegenschaftResponse() {
        return new AddLiegenschaftResponse();
    }

    /**
     * Create an instance of {@link UpdateWaermeerzeugerResponse }
     * 
     */
    public UpdateWaermeerzeugerResponse createUpdateWaermeerzeugerResponse() {
        return new UpdateWaermeerzeugerResponse();
    }

    /**
     * Create an instance of {@link DeleteWaermeerzeugerById }
     * 
     */
    public DeleteWaermeerzeugerById createDeleteWaermeerzeugerById() {
        return new DeleteWaermeerzeugerById();
    }

    /**
     * Create an instance of {@link FindLiegenschaftByOrtResponse }
     * 
     */
    public FindLiegenschaftByOrtResponse createFindLiegenschaftByOrtResponse() {
        return new FindLiegenschaftByOrtResponse();
    }

    /**
     * Create an instance of {@link DeleteMitarbeiterResponse }
     * 
     */
    public DeleteMitarbeiterResponse createDeleteMitarbeiterResponse() {
        return new DeleteMitarbeiterResponse();
    }

    /**
     * Create an instance of {@link UpdateMessung }
     * 
     */
    public UpdateMessung createUpdateMessung() {
        return new UpdateMessung();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByArbeitetBisResponse }
     * 
     */
    public FindMitarbeiterByArbeitetBisResponse createFindMitarbeiterByArbeitetBisResponse() {
        return new FindMitarbeiterByArbeitetBisResponse();
    }

    /**
     * Create an instance of {@link FindKontaktByRolleExtern }
     * 
     */
    public FindKontaktByRolleExtern createFindKontaktByRolleExtern() {
        return new FindKontaktByRolleExtern();
    }

    /**
     * Create an instance of {@link FindBenutzerById }
     * 
     */
    public FindBenutzerById createFindBenutzerById() {
        return new FindBenutzerById();
    }

    /**
     * Create an instance of {@link FindBenutzerByIdResponse }
     * 
     */
    public FindBenutzerByIdResponse createFindBenutzerByIdResponse() {
        return new FindBenutzerByIdResponse();
    }

    /**
     * Create an instance of {@link FindLiegenschaftByStrasseResponse }
     * 
     */
    public FindLiegenschaftByStrasseResponse createFindLiegenschaftByStrasseResponse() {
        return new FindLiegenschaftByStrasseResponse();
    }

    /**
     * Create an instance of {@link DeleteKontakt }
     * 
     */
    public DeleteKontakt createDeleteKontakt() {
        return new DeleteKontakt();
    }

    /**
     * Create an instance of {@link FindBenutzerByUsernamePasswordResponse }
     * 
     */
    public FindBenutzerByUsernamePasswordResponse createFindBenutzerByUsernamePasswordResponse() {
        return new FindBenutzerByUsernamePasswordResponse();
    }

    /**
     * Create an instance of {@link AddLiegenschaft }
     * 
     */
    public AddLiegenschaft createAddLiegenschaft() {
        return new AddLiegenschaft();
    }

    /**
     * Create an instance of {@link FindAllBenutzerResponse }
     * 
     */
    public FindAllBenutzerResponse createFindAllBenutzerResponse() {
        return new FindAllBenutzerResponse();
    }

    /**
     * Create an instance of {@link FindKontaktByVorname }
     * 
     */
    public FindKontaktByVorname createFindKontaktByVorname() {
        return new FindKontaktByVorname();
    }

    /**
     * Create an instance of {@link UpdateOrtResponse }
     * 
     */
    public UpdateOrtResponse createUpdateOrtResponse() {
        return new UpdateOrtResponse();
    }

    /**
     * Create an instance of {@link FindAllFeuerungsanlageResponse }
     * 
     */
    public FindAllFeuerungsanlageResponse createFindAllFeuerungsanlageResponse() {
        return new FindAllFeuerungsanlageResponse();
    }

    /**
     * Create an instance of {@link FindBrennerById }
     * 
     */
    public FindBrennerById createFindBrennerById() {
        return new FindBrennerById();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageByWaermeerzeugerResponse }
     * 
     */
    public FindFeuerungsanlageByWaermeerzeugerResponse createFindFeuerungsanlageByWaermeerzeugerResponse() {
        return new FindFeuerungsanlageByWaermeerzeugerResponse();
    }

    /**
     * Create an instance of {@link FindAuftragByMitarbeiterResponse }
     * 
     */
    public FindAuftragByMitarbeiterResponse createFindAuftragByMitarbeiterResponse() {
        return new FindAuftragByMitarbeiterResponse();
    }

    /**
     * Create an instance of {@link UpdateMitarbeiterResponse }
     * 
     */
    public UpdateMitarbeiterResponse createUpdateMitarbeiterResponse() {
        return new UpdateMitarbeiterResponse();
    }

    /**
     * Create an instance of {@link FindOrtByIdResponse }
     * 
     */
    public FindOrtByIdResponse createFindOrtByIdResponse() {
        return new FindOrtByIdResponse();
    }

    /**
     * Create an instance of {@link AddKontaktResponse }
     * 
     */
    public AddKontaktResponse createAddKontaktResponse() {
        return new AddKontaktResponse();
    }

    /**
     * Create an instance of {@link DeleteLiegenschaftByIdResponse }
     * 
     */
    public DeleteLiegenschaftByIdResponse createDeleteLiegenschaftByIdResponse() {
        return new DeleteLiegenschaftByIdResponse();
    }

    /**
     * Create an instance of {@link FindBrennerByBaujahr }
     * 
     */
    public FindBrennerByBaujahr createFindBrennerByBaujahr() {
        return new FindBrennerByBaujahr();
    }

    /**
     * Create an instance of {@link FindBenutzerByUsernamePassword }
     * 
     */
    public FindBenutzerByUsernamePassword createFindBenutzerByUsernamePassword() {
        return new FindBenutzerByUsernamePassword();
    }

    /**
     * Create an instance of {@link DeleteKontaktById }
     * 
     */
    public DeleteKontaktById createDeleteKontaktById() {
        return new DeleteKontaktById();
    }

    /**
     * Create an instance of {@link DeleteFeuerungsanlageResponse }
     * 
     */
    public DeleteFeuerungsanlageResponse createDeleteFeuerungsanlageResponse() {
        return new DeleteFeuerungsanlageResponse();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageByLiegenschaftResponse }
     * 
     */
    public FindFeuerungsanlageByLiegenschaftResponse createFindFeuerungsanlageByLiegenschaftResponse() {
        return new FindFeuerungsanlageByLiegenschaftResponse();
    }

    /**
     * Create an instance of {@link FindKontaktByVornameResponse }
     * 
     */
    public FindKontaktByVornameResponse createFindKontaktByVornameResponse() {
        return new FindKontaktByVornameResponse();
    }

    /**
     * Create an instance of {@link FindAuftragByDatum }
     * 
     */
    public FindAuftragByDatum createFindAuftragByDatum() {
        return new FindAuftragByDatum();
    }

    /**
     * Create an instance of {@link FindLiegenschaftByStrasse }
     * 
     */
    public FindLiegenschaftByStrasse createFindLiegenschaftByStrasse() {
        return new FindLiegenschaftByStrasse();
    }

    /**
     * Create an instance of {@link UpdateMitarbeiter }
     * 
     */
    public UpdateMitarbeiter createUpdateMitarbeiter() {
        return new UpdateMitarbeiter();
    }

    /**
     * Create an instance of {@link DeleteMessung }
     * 
     */
    public DeleteMessung createDeleteMessung() {
        return new DeleteMessung();
    }

    /**
     * Create an instance of {@link AddAuftragResponse }
     * 
     */
    public AddAuftragResponse createAddAuftragResponse() {
        return new AddAuftragResponse();
    }

    /**
     * Create an instance of {@link AddMessungResponse }
     * 
     */
    public AddMessungResponse createAddMessungResponse() {
        return new AddMessungResponse();
    }

    /**
     * Create an instance of {@link AddOrtResponse }
     * 
     */
    public AddOrtResponse createAddOrtResponse() {
        return new AddOrtResponse();
    }

    /**
     * Create an instance of {@link DeleteBrennerByIdResponse }
     * 
     */
    public DeleteBrennerByIdResponse createDeleteBrennerByIdResponse() {
        return new DeleteBrennerByIdResponse();
    }

    /**
     * Create an instance of {@link UpdatLiegenschaftResponse }
     * 
     */
    public UpdatLiegenschaftResponse createUpdatLiegenschaftResponse() {
        return new UpdatLiegenschaftResponse();
    }

    /**
     * Create an instance of {@link FindAllWaermeerzeugerResponse }
     * 
     */
    public FindAllWaermeerzeugerResponse createFindAllWaermeerzeugerResponse() {
        return new FindAllWaermeerzeugerResponse();
    }

    /**
     * Create an instance of {@link DeleteFeuerungsanlageByIdResponse }
     * 
     */
    public DeleteFeuerungsanlageByIdResponse createDeleteFeuerungsanlageByIdResponse() {
        return new DeleteFeuerungsanlageByIdResponse();
    }

    /**
     * Create an instance of {@link FindBrennerByArt }
     * 
     */
    public FindBrennerByArt createFindBrennerByArt() {
        return new FindBrennerByArt();
    }

    /**
     * Create an instance of {@link UpdatLiegenschaft }
     * 
     */
    public UpdatLiegenschaft createUpdatLiegenschaft() {
        return new UpdatLiegenschaft();
    }

    /**
     * Create an instance of {@link FindAllOrtResponse }
     * 
     */
    public FindAllOrtResponse createFindAllOrtResponse() {
        return new FindAllOrtResponse();
    }

    /**
     * Create an instance of {@link DeleteWaermeerzeugerByIdResponse }
     * 
     */
    public DeleteWaermeerzeugerByIdResponse createDeleteWaermeerzeugerByIdResponse() {
        return new DeleteWaermeerzeugerByIdResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByOrtResponse }
     * 
     */
    public FindMitarbeiterByOrtResponse createFindMitarbeiterByOrtResponse() {
        return new FindMitarbeiterByOrtResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByRolleInternResponse }
     * 
     */
    public FindMitarbeiterByRolleInternResponse createFindMitarbeiterByRolleInternResponse() {
        return new FindMitarbeiterByRolleInternResponse();
    }

    /**
     * Create an instance of {@link AddOrt }
     * 
     */
    public AddOrt createAddOrt() {
        return new AddOrt();
    }

    /**
     * Create an instance of {@link FindKontaktByName }
     * 
     */
    public FindKontaktByName createFindKontaktByName() {
        return new FindKontaktByName();
    }

    /**
     * Create an instance of {@link DeleteFeuerungsanlageById }
     * 
     */
    public DeleteFeuerungsanlageById createDeleteFeuerungsanlageById() {
        return new DeleteFeuerungsanlageById();
    }

    /**
     * Create an instance of {@link FindAuftragByDateAndMitarbeiter }
     * 
     */
    public FindAuftragByDateAndMitarbeiter createFindAuftragByDateAndMitarbeiter() {
        return new FindAuftragByDateAndMitarbeiter();
    }

    /**
     * Create an instance of {@link UpdateAuftragResponse }
     * 
     */
    public UpdateAuftragResponse createUpdateAuftragResponse() {
        return new UpdateAuftragResponse();
    }

    /**
     * Create an instance of {@link FindAllKontakt }
     * 
     */
    public FindAllKontakt createFindAllKontakt() {
        return new FindAllKontakt();
    }

    /**
     * Create an instance of {@link UpdateBrenner }
     * 
     */
    public UpdateBrenner createUpdateBrenner() {
        return new UpdateBrenner();
    }

    /**
     * Create an instance of {@link FindBrennerByTyp }
     * 
     */
    public FindBrennerByTyp createFindBrennerByTyp() {
        return new FindBrennerByTyp();
    }

    /**
     * Create an instance of {@link FindAllOrt }
     * 
     */
    public FindAllOrt createFindAllOrt() {
        return new FindAllOrt();
    }

    /**
     * Create an instance of {@link FindAllMessung }
     * 
     */
    public FindAllMessung createFindAllMessung() {
        return new FindAllMessung();
    }

    /**
     * Create an instance of {@link FindFeuerungsanlageByBrennerResponse }
     * 
     */
    public FindFeuerungsanlageByBrennerResponse createFindFeuerungsanlageByBrennerResponse() {
        return new FindFeuerungsanlageByBrennerResponse();
    }

    /**
     * Create an instance of {@link UpdateFeuerungsanlageResponse }
     * 
     */
    public UpdateFeuerungsanlageResponse createUpdateFeuerungsanlageResponse() {
        return new UpdateFeuerungsanlageResponse();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerByTyp }
     * 
     */
    public FindWaermeerzeugerByTyp createFindWaermeerzeugerByTyp() {
        return new FindWaermeerzeugerByTyp();
    }

    /**
     * Create an instance of {@link FindKontaktByStrasse }
     * 
     */
    public FindKontaktByStrasse createFindKontaktByStrasse() {
        return new FindKontaktByStrasse();
    }

    /**
     * Create an instance of {@link DeleteBenutzer }
     * 
     */
    public DeleteBenutzer createDeleteBenutzer() {
        return new DeleteBenutzer();
    }

    /**
     * Create an instance of {@link DeleteBrennerById }
     * 
     */
    public DeleteBrennerById createDeleteBrennerById() {
        return new DeleteBrennerById();
    }

    /**
     * Create an instance of {@link FindKontaktByIdResponse }
     * 
     */
    public FindKontaktByIdResponse createFindKontaktByIdResponse() {
        return new FindKontaktByIdResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByIdResponse }
     * 
     */
    public FindMitarbeiterByIdResponse createFindMitarbeiterByIdResponse() {
        return new FindMitarbeiterByIdResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByStrasseResponse }
     * 
     */
    public FindMitarbeiterByStrasseResponse createFindMitarbeiterByStrasseResponse() {
        return new FindMitarbeiterByStrasseResponse();
    }

    /**
     * Create an instance of {@link AddFeuerungsanlage }
     * 
     */
    public AddFeuerungsanlage createAddFeuerungsanlage() {
        return new AddFeuerungsanlage();
    }

    /**
     * Create an instance of {@link DeleteOrt }
     * 
     */
    public DeleteOrt createDeleteOrt() {
        return new DeleteOrt();
    }

    /**
     * Create an instance of {@link AddBenutzerResponse }
     * 
     */
    public AddBenutzerResponse createAddBenutzerResponse() {
        return new AddBenutzerResponse();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByArbeitetSeit }
     * 
     */
    public FindMitarbeiterByArbeitetSeit createFindMitarbeiterByArbeitetSeit() {
        return new FindMitarbeiterByArbeitetSeit();
    }

    /**
     * Create an instance of {@link AddWaermeerzeugerResponse }
     * 
     */
    public AddWaermeerzeugerResponse createAddWaermeerzeugerResponse() {
        return new AddWaermeerzeugerResponse();
    }

    /**
     * Create an instance of {@link FindMessungByBeurteilungNotOkResponse }
     * 
     */
    public FindMessungByBeurteilungNotOkResponse createFindMessungByBeurteilungNotOkResponse() {
        return new FindMessungByBeurteilungNotOkResponse();
    }

    /**
     * Create an instance of {@link FindLiegenschaftById }
     * 
     */
    public FindLiegenschaftById createFindLiegenschaftById() {
        return new FindLiegenschaftById();
    }

    /**
     * Create an instance of {@link FindMitarbeiterByName }
     * 
     */
    public FindMitarbeiterByName createFindMitarbeiterByName() {
        return new FindMitarbeiterByName();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link DeleteBrenner }
     * 
     */
    public DeleteBrenner createDeleteBrenner() {
        return new DeleteBrenner();
    }

    /**
     * Create an instance of {@link DeleteOrtResponse }
     * 
     */
    public DeleteOrtResponse createDeleteOrtResponse() {
        return new DeleteOrtResponse();
    }

    /**
     * Create an instance of {@link FindOrtByPlzResponse }
     * 
     */
    public FindOrtByPlzResponse createFindOrtByPlzResponse() {
        return new FindOrtByPlzResponse();
    }

    /**
     * Create an instance of {@link FindWaermeerzeugerByTypResponse }
     * 
     */
    public FindWaermeerzeugerByTypResponse createFindWaermeerzeugerByTypResponse() {
        return new FindWaermeerzeugerByTypResponse();
    }

    /**
     * Create an instance of {@link DeleteMessungById }
     * 
     */
    public DeleteMessungById createDeleteMessungById() {
        return new DeleteMessungById();
    }

    /**
     * Create an instance of {@link DeleteLiegenschaftResponse }
     * 
     */
    public DeleteLiegenschaftResponse createDeleteLiegenschaftResponse() {
        return new DeleteLiegenschaftResponse();
    }

    /**
     * Create an instance of {@link FindMessungByDatumResponse }
     * 
     */
    public FindMessungByDatumResponse createFindMessungByDatumResponse() {
        return new FindMessungByDatumResponse();
    }

    /**
     * Create an instance of {@link DeleteMessungByIdResponse }
     * 
     */
    public DeleteMessungByIdResponse createDeleteMessungByIdResponse() {
        return new DeleteMessungByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteMitarbeiterById }
     * 
     */
    public DeleteMitarbeiterById createDeleteMitarbeiterById() {
        return new DeleteMitarbeiterById();
    }

    /**
     * Create an instance of {@link Auftrag }
     * 
     */
    public Auftrag createAuftrag() {
        return new Auftrag();
    }

    /**
     * Create an instance of {@link Waermeerzeuger }
     * 
     */
    public Waermeerzeuger createWaermeerzeuger() {
        return new Waermeerzeuger();
    }

    /**
     * Create an instance of {@link Brenner }
     * 
     */
    public Brenner createBrenner() {
        return new Brenner();
    }

    /**
     * Create an instance of {@link Liegenschaft }
     * 
     */
    public Liegenschaft createLiegenschaft() {
        return new Liegenschaft();
    }

    /**
     * Create an instance of {@link Benutzer }
     * 
     */
    public Benutzer createBenutzer() {
        return new Benutzer();
    }

    /**
     * Create an instance of {@link Kontakt }
     * 
     */
    public Kontakt createKontakt() {
        return new Kontakt();
    }

    /**
     * Create an instance of {@link Ort }
     * 
     */
    public Ort createOrt() {
        return new Ort();
    }

    /**
     * Create an instance of {@link Messung }
     * 
     */
    public Messung createMessung() {
        return new Messung();
    }

    /**
     * Create an instance of {@link Feuerungsanlage }
     * 
     */
    public Feuerungsanlage createFeuerungsanlage() {
        return new Feuerungsanlage();
    }

    /**
     * Create an instance of {@link Mitarbeiter }
     * 
     */
    public Mitarbeiter createMitarbeiter() {
        return new Mitarbeiter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMessungByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMessungByIdResponse")
    public JAXBElement<FindMessungByIdResponse> createFindMessungByIdResponse(FindMessungByIdResponse value) {
        return new JAXBElement<FindMessungByIdResponse>(_FindMessungByIdResponse_QNAME, FindMessungByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllBrenner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllBrenner")
    public JAXBElement<FindAllBrenner> createFindAllBrenner(FindAllBrenner value) {
        return new JAXBElement<FindAllBrenner>(_FindAllBrenner_QNAME, FindAllBrenner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateKontaktResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateKontaktResponse")
    public JAXBElement<UpdateKontaktResponse> createUpdateKontaktResponse(UpdateKontaktResponse value) {
        return new JAXBElement<UpdateKontaktResponse>(_UpdateKontaktResponse_QNAME, UpdateKontaktResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByNameResponse")
    public JAXBElement<FindMitarbeiterByNameResponse> createFindMitarbeiterByNameResponse(FindMitarbeiterByNameResponse value) {
        return new JAXBElement<FindMitarbeiterByNameResponse>(_FindMitarbeiterByNameResponse_QNAME, FindMitarbeiterByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAuftrag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateAuftrag")
    public JAXBElement<UpdateAuftrag> createUpdateAuftrag(UpdateAuftrag value) {
        return new JAXBElement<UpdateAuftrag>(_UpdateAuftrag_QNAME, UpdateAuftrag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWaermeerzeuger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateWaermeerzeuger")
    public JAXBElement<UpdateWaermeerzeuger> createUpdateWaermeerzeuger(UpdateWaermeerzeuger value) {
        return new JAXBElement<UpdateWaermeerzeuger>(_UpdateWaermeerzeuger_QNAME, UpdateWaermeerzeuger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageByWaermeerzeuger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageByWaermeerzeuger")
    public JAXBElement<FindFeuerungsanlageByWaermeerzeuger> createFindFeuerungsanlageByWaermeerzeuger(FindFeuerungsanlageByWaermeerzeuger value) {
        return new JAXBElement<FindFeuerungsanlageByWaermeerzeuger>(_FindFeuerungsanlageByWaermeerzeuger_QNAME, FindFeuerungsanlageByWaermeerzeuger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerByBaujahrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerByBaujahrResponse")
    public JAXBElement<FindBrennerByBaujahrResponse> createFindBrennerByBaujahrResponse(FindBrennerByBaujahrResponse value) {
        return new JAXBElement<FindBrennerByBaujahrResponse>(_FindBrennerByBaujahrResponse_QNAME, FindBrennerByBaujahrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByArbeitetBis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByArbeitetBis")
    public JAXBElement<FindMitarbeiterByArbeitetBis> createFindMitarbeiterByArbeitetBis(FindMitarbeiterByArbeitetBis value) {
        return new JAXBElement<FindMitarbeiterByArbeitetBis>(_FindMitarbeiterByArbeitetBis_QNAME, FindMitarbeiterByArbeitetBis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllFeuerungsanlage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllFeuerungsanlage")
    public JAXBElement<FindAllFeuerungsanlage> createFindAllFeuerungsanlage(FindAllFeuerungsanlage value) {
        return new JAXBElement<FindAllFeuerungsanlage>(_FindAllFeuerungsanlage_QNAME, FindAllFeuerungsanlage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageByBrenner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageByBrenner")
    public JAXBElement<FindFeuerungsanlageByBrenner> createFindFeuerungsanlageByBrenner(FindFeuerungsanlageByBrenner value) {
        return new JAXBElement<FindFeuerungsanlageByBrenner>(_FindFeuerungsanlageByBrenner_QNAME, FindFeuerungsanlageByBrenner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBenutzerByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBenutzerByUsernameResponse")
    public JAXBElement<FindBenutzerByUsernameResponse> createFindBenutzerByUsernameResponse(FindBenutzerByUsernameResponse value) {
        return new JAXBElement<FindBenutzerByUsernameResponse>(_FindBenutzerByUsernameResponse_QNAME, FindBenutzerByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftByOrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftByOrt")
    public JAXBElement<FindLiegenschaftByOrt> createFindLiegenschaftByOrt(FindLiegenschaftByOrt value) {
        return new JAXBElement<FindLiegenschaftByOrt>(_FindLiegenschaftByOrt_QNAME, FindLiegenschaftByOrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByKontaktResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByKontaktResponse")
    public JAXBElement<FindAuftragByKontaktResponse> createFindAuftragByKontaktResponse(FindAuftragByKontaktResponse value) {
        return new JAXBElement<FindAuftragByKontaktResponse>(_FindAuftragByKontaktResponse_QNAME, FindAuftragByKontaktResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMitarbeiterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addMitarbeiterResponse")
    public JAXBElement<AddMitarbeiterResponse> createAddMitarbeiterResponse(AddMitarbeiterResponse value) {
        return new JAXBElement<AddMitarbeiterResponse>(_AddMitarbeiterResponse_QNAME, AddMitarbeiterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByVornameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByVornameResponse")
    public JAXBElement<FindMitarbeiterByVornameResponse> createFindMitarbeiterByVornameResponse(FindMitarbeiterByVornameResponse value) {
        return new JAXBElement<FindMitarbeiterByVornameResponse>(_FindMitarbeiterByVornameResponse_QNAME, FindMitarbeiterByVornameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByDatumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByDatumResponse")
    public JAXBElement<FindAuftragByDatumResponse> createFindAuftragByDatumResponse(FindAuftragByDatumResponse value) {
        return new JAXBElement<FindAuftragByDatumResponse>(_FindAuftragByDatumResponse_QNAME, FindAuftragByDatumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByLiegenschaftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByLiegenschaftResponse")
    public JAXBElement<FindAuftragByLiegenschaftResponse> createFindAuftragByLiegenschaftResponse(FindAuftragByLiegenschaftResponse value) {
        return new JAXBElement<FindAuftragByLiegenschaftResponse>(_FindAuftragByLiegenschaftResponse_QNAME, FindAuftragByLiegenschaftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFeuerungsanlageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addFeuerungsanlageResponse")
    public JAXBElement<AddFeuerungsanlageResponse> createAddFeuerungsanlageResponse(AddFeuerungsanlageResponse value) {
        return new JAXBElement<AddFeuerungsanlageResponse>(_AddFeuerungsanlageResponse_QNAME, AddFeuerungsanlageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerByIdResponse")
    public JAXBElement<FindWaermeerzeugerByIdResponse> createFindWaermeerzeugerByIdResponse(FindWaermeerzeugerByIdResponse value) {
        return new JAXBElement<FindWaermeerzeugerByIdResponse>(_FindWaermeerzeugerByIdResponse_QNAME, FindWaermeerzeugerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerByArtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerByArtResponse")
    public JAXBElement<FindBrennerByArtResponse> createFindBrennerByArtResponse(FindBrennerByArtResponse value) {
        return new JAXBElement<FindBrennerByArtResponse>(_FindBrennerByArtResponse_QNAME, FindBrennerByArtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByDateAndMitarbeiterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByDateAndMitarbeiterResponse")
    public JAXBElement<FindAuftragByDateAndMitarbeiterResponse> createFindAuftragByDateAndMitarbeiterResponse(FindAuftragByDateAndMitarbeiterResponse value) {
        return new JAXBElement<FindAuftragByDateAndMitarbeiterResponse>(_FindAuftragByDateAndMitarbeiterResponse_QNAME, FindAuftragByDateAndMitarbeiterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllAuftragResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllAuftragResponse")
    public JAXBElement<FindAllAuftragResponse> createFindAllAuftragResponse(FindAllAuftragResponse value) {
        return new JAXBElement<FindAllAuftragResponse>(_FindAllAuftragResponse_QNAME, FindAllAuftragResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBrenner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addBrenner")
    public JAXBElement<AddBrenner> createAddBrenner(AddBrenner value) {
        return new JAXBElement<AddBrenner>(_AddBrenner_QNAME, AddBrenner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByRolleIntern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByRolleIntern")
    public JAXBElement<FindMitarbeiterByRolleIntern> createFindMitarbeiterByRolleIntern(FindMitarbeiterByRolleIntern value) {
        return new JAXBElement<FindMitarbeiterByRolleIntern>(_FindMitarbeiterByRolleIntern_QNAME, FindMitarbeiterByRolleIntern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByAuftragsNummer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByAuftragsNummer")
    public JAXBElement<FindAuftragByAuftragsNummer> createFindAuftragByAuftragsNummer(FindAuftragByAuftragsNummer value) {
        return new JAXBElement<FindAuftragByAuftragsNummer>(_FindAuftragByAuftragsNummer_QNAME, FindAuftragByAuftragsNummer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerByBrennstoff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerByBrennstoff")
    public JAXBElement<FindWaermeerzeugerByBrennstoff> createFindWaermeerzeugerByBrennstoff(FindWaermeerzeugerByBrennstoff value) {
        return new JAXBElement<FindWaermeerzeugerByBrennstoff>(_FindWaermeerzeugerByBrennstoff_QNAME, FindWaermeerzeugerByBrennstoff.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBenutzerByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBenutzerByUsername")
    public JAXBElement<FindBenutzerByUsername> createFindBenutzerByUsername(FindBenutzerByUsername value) {
        return new JAXBElement<FindBenutzerByUsername>(_FindBenutzerByUsername_QNAME, FindBenutzerByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByNameVorname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByNameVorname")
    public JAXBElement<FindMitarbeiterByNameVorname> createFindMitarbeiterByNameVorname(FindMitarbeiterByNameVorname value) {
        return new JAXBElement<FindMitarbeiterByNameVorname>(_FindMitarbeiterByNameVorname_QNAME, FindMitarbeiterByNameVorname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerById")
    public JAXBElement<FindWaermeerzeugerById> createFindWaermeerzeugerById(FindWaermeerzeugerById value) {
        return new JAXBElement<FindWaermeerzeugerById>(_FindWaermeerzeugerById_QNAME, FindWaermeerzeugerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFeuerungsanlage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateFeuerungsanlage")
    public JAXBElement<UpdateFeuerungsanlage> createUpdateFeuerungsanlage(UpdateFeuerungsanlage value) {
        return new JAXBElement<UpdateFeuerungsanlage>(_UpdateFeuerungsanlage_QNAME, UpdateFeuerungsanlage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageByLiegenschaft }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageByLiegenschaft")
    public JAXBElement<FindFeuerungsanlageByLiegenschaft> createFindFeuerungsanlageByLiegenschaft(FindFeuerungsanlageByLiegenschaft value) {
        return new JAXBElement<FindFeuerungsanlageByLiegenschaft>(_FindFeuerungsanlageByLiegenschaft_QNAME, FindFeuerungsanlageByLiegenschaft.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLiegenschaft }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteLiegenschaft")
    public JAXBElement<DeleteLiegenschaft> createDeleteLiegenschaft(DeleteLiegenschaft value) {
        return new JAXBElement<DeleteLiegenschaft>(_DeleteLiegenschaft_QNAME, DeleteLiegenschaft.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllLiegenschaft }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllLiegenschaft")
    public JAXBElement<FindAllLiegenschaft> createFindAllLiegenschaft(FindAllLiegenschaft value) {
        return new JAXBElement<FindAllLiegenschaft>(_FindAllLiegenschaft_QNAME, FindAllLiegenschaft.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAuftragResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteAuftragResponse")
    public JAXBElement<DeleteAuftragResponse> createDeleteAuftragResponse(DeleteAuftragResponse value) {
        return new JAXBElement<DeleteAuftragResponse>(_DeleteAuftragResponse_QNAME, DeleteAuftragResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLiegenschaftById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteLiegenschaftById")
    public JAXBElement<DeleteLiegenschaftById> createDeleteLiegenschaftById(DeleteLiegenschaftById value) {
        return new JAXBElement<DeleteLiegenschaftById>(_DeleteLiegenschaftById_QNAME, DeleteLiegenschaftById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAuftrag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteAuftrag")
    public JAXBElement<DeleteAuftrag> createDeleteAuftrag(DeleteAuftrag value) {
        return new JAXBElement<DeleteAuftrag>(_DeleteAuftrag_QNAME, DeleteAuftrag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAuftragById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteAuftragById")
    public JAXBElement<DeleteAuftragById> createDeleteAuftragById(DeleteAuftragById value) {
        return new JAXBElement<DeleteAuftragById>(_DeleteAuftragById_QNAME, DeleteAuftragById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMessungResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateMessungResponse")
    public JAXBElement<UpdateMessungResponse> createUpdateMessungResponse(UpdateMessungResponse value) {
        return new JAXBElement<UpdateMessungResponse>(_UpdateMessungResponse_QNAME, UpdateMessungResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerByBrennstoffResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerByBrennstoffResponse")
    public JAXBElement<FindWaermeerzeugerByBrennstoffResponse> createFindWaermeerzeugerByBrennstoffResponse(FindWaermeerzeugerByBrennstoffResponse value) {
        return new JAXBElement<FindWaermeerzeugerByBrennstoffResponse>(_FindWaermeerzeugerByBrennstoffResponse_QNAME, FindWaermeerzeugerByBrennstoffResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllMitarbeiter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllMitarbeiter")
    public JAXBElement<FindAllMitarbeiter> createFindAllMitarbeiter(FindAllMitarbeiter value) {
        return new JAXBElement<FindAllMitarbeiter>(_FindAllMitarbeiter_QNAME, FindAllMitarbeiter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktById")
    public JAXBElement<FindKontaktById> createFindKontaktById(FindKontaktById value) {
        return new JAXBElement<FindKontaktById>(_FindKontaktById_QNAME, FindKontaktById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByRolleExternResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByRolleExternResponse")
    public JAXBElement<FindKontaktByRolleExternResponse> createFindKontaktByRolleExternResponse(FindKontaktByRolleExternResponse value) {
        return new JAXBElement<FindKontaktByRolleExternResponse>(_FindKontaktByRolleExternResponse_QNAME, FindKontaktByRolleExternResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteBenutzerResponse")
    public JAXBElement<DeleteBenutzerResponse> createDeleteBenutzerResponse(DeleteBenutzerResponse value) {
        return new JAXBElement<DeleteBenutzerResponse>(_DeleteBenutzerResponse_QNAME, DeleteBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrtByOrtBez }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findOrtByOrtBez")
    public JAXBElement<FindOrtByOrtBez> createFindOrtByOrtBez(FindOrtByOrtBez value) {
        return new JAXBElement<FindOrtByOrtBez>(_FindOrtByOrtBez_QNAME, FindOrtByOrtBez.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByAuftragsNummerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByAuftragsNummerResponse")
    public JAXBElement<FindAuftragByAuftragsNummerResponse> createFindAuftragByAuftragsNummerResponse(FindAuftragByAuftragsNummerResponse value) {
        return new JAXBElement<FindAuftragByAuftragsNummerResponse>(_FindAuftragByAuftragsNummerResponse_QNAME, FindAuftragByAuftragsNummerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftByKontaktResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftByKontaktResponse")
    public JAXBElement<FindLiegenschaftByKontaktResponse> createFindLiegenschaftByKontaktResponse(FindLiegenschaftByKontaktResponse value) {
        return new JAXBElement<FindLiegenschaftByKontaktResponse>(_FindLiegenschaftByKontaktResponse_QNAME, FindLiegenschaftByKontaktResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByBenutzerResponse")
    public JAXBElement<FindMitarbeiterByBenutzerResponse> createFindMitarbeiterByBenutzerResponse(FindMitarbeiterByBenutzerResponse value) {
        return new JAXBElement<FindMitarbeiterByBenutzerResponse>(_FindMitarbeiterByBenutzerResponse_QNAME, FindMitarbeiterByBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftByIdResponse")
    public JAXBElement<FindLiegenschaftByIdResponse> createFindLiegenschaftByIdResponse(FindLiegenschaftByIdResponse value) {
        return new JAXBElement<FindLiegenschaftByIdResponse>(_FindLiegenschaftByIdResponse_QNAME, FindLiegenschaftByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMessungResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMessungResponse")
    public JAXBElement<DeleteMessungResponse> createDeleteMessungResponse(DeleteMessungResponse value) {
        return new JAXBElement<DeleteMessungResponse>(_DeleteMessungResponse_QNAME, DeleteMessungResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBrennerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addBrennerResponse")
    public JAXBElement<AddBrennerResponse> createAddBrennerResponse(AddBrennerResponse value) {
        return new JAXBElement<AddBrennerResponse>(_AddBrennerResponse_QNAME, AddBrennerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAuftragByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteAuftragByIdResponse")
    public JAXBElement<DeleteAuftragByIdResponse> createDeleteAuftragByIdResponse(DeleteAuftragByIdResponse value) {
        return new JAXBElement<DeleteAuftragByIdResponse>(_DeleteAuftragByIdResponse_QNAME, DeleteAuftragByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByNameResponse")
    public JAXBElement<FindKontaktByNameResponse> createFindKontaktByNameResponse(FindKontaktByNameResponse value) {
        return new JAXBElement<FindKontaktByNameResponse>(_FindKontaktByNameResponse_QNAME, FindKontaktByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrtByOrtBezResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findOrtByOrtBezResponse")
    public JAXBElement<FindOrtByOrtBezResponse> createFindOrtByOrtBezResponse(FindOrtByOrtBezResponse value) {
        return new JAXBElement<FindOrtByOrtBezResponse>(_FindOrtByOrtBezResponse_QNAME, FindOrtByOrtBezResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerByTypResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerByTypResponse")
    public JAXBElement<FindBrennerByTypResponse> createFindBrennerByTypResponse(FindBrennerByTypResponse value) {
        return new JAXBElement<FindBrennerByTypResponse>(_FindBrennerByTypResponse_QNAME, FindBrennerByTypResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrtById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findOrtById")
    public JAXBElement<FindOrtById> createFindOrtById(FindOrtById value) {
        return new JAXBElement<FindOrtById>(_FindOrtById_QNAME, FindOrtById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByBenutzer")
    public JAXBElement<FindMitarbeiterByBenutzer> createFindMitarbeiterByBenutzer(FindMitarbeiterByBenutzer value) {
        return new JAXBElement<FindMitarbeiterByBenutzer>(_FindMitarbeiterByBenutzer_QNAME, FindMitarbeiterByBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWaermeerzeugerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteWaermeerzeugerResponse")
    public JAXBElement<DeleteWaermeerzeugerResponse> createDeleteWaermeerzeugerResponse(DeleteWaermeerzeugerResponse value) {
        return new JAXBElement<DeleteWaermeerzeugerResponse>(_DeleteWaermeerzeugerResponse_QNAME, DeleteWaermeerzeugerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMitarbeiter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMitarbeiter")
    public JAXBElement<DeleteMitarbeiter> createDeleteMitarbeiter(DeleteMitarbeiter value) {
        return new JAXBElement<DeleteMitarbeiter>(_DeleteMitarbeiter_QNAME, DeleteMitarbeiter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addBenutzer")
    public JAXBElement<AddBenutzer> createAddBenutzer(AddBenutzer value) {
        return new JAXBElement<AddBenutzer>(_AddBenutzer_QNAME, AddBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteKontaktResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteKontaktResponse")
    public JAXBElement<DeleteKontaktResponse> createDeleteKontaktResponse(DeleteKontaktResponse value) {
        return new JAXBElement<DeleteKontaktResponse>(_DeleteKontaktResponse_QNAME, DeleteKontaktResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBrennerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateBrennerResponse")
    public JAXBElement<UpdateBrennerResponse> createUpdateBrennerResponse(UpdateBrennerResponse value) {
        return new JAXBElement<UpdateBrennerResponse>(_UpdateBrennerResponse_QNAME, UpdateBrennerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMessungByDatum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMessungByDatum")
    public JAXBElement<FindMessungByDatum> createFindMessungByDatum(FindMessungByDatum value) {
        return new JAXBElement<FindMessungByDatum>(_FindMessungByDatum_QNAME, FindMessungByDatum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllMitarbeiterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllMitarbeiterResponse")
    public JAXBElement<FindAllMitarbeiterResponse> createFindAllMitarbeiterResponse(FindAllMitarbeiterResponse value) {
        return new JAXBElement<FindAllMitarbeiterResponse>(_FindAllMitarbeiterResponse_QNAME, FindAllMitarbeiterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByLiegenschaft }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByLiegenschaft")
    public JAXBElement<FindAuftragByLiegenschaft> createFindAuftragByLiegenschaft(FindAuftragByLiegenschaft value) {
        return new JAXBElement<FindAuftragByLiegenschaft>(_FindAuftragByLiegenschaft_QNAME, FindAuftragByLiegenschaft.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMessungByBeurteilungNotOk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMessungByBeurteilungNotOk")
    public JAXBElement<FindMessungByBeurteilungNotOk> createFindMessungByBeurteilungNotOk(FindMessungByBeurteilungNotOk value) {
        return new JAXBElement<FindMessungByBeurteilungNotOk>(_FindMessungByBeurteilungNotOk_QNAME, FindMessungByBeurteilungNotOk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftByKontakt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftByKontakt")
    public JAXBElement<FindLiegenschaftByKontakt> createFindLiegenschaftByKontakt(FindLiegenschaftByKontakt value) {
        return new JAXBElement<FindLiegenschaftByKontakt>(_FindLiegenschaftByKontakt_QNAME, FindLiegenschaftByKontakt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByMitarbeiter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByMitarbeiter")
    public JAXBElement<FindAuftragByMitarbeiter> createFindAuftragByMitarbeiter(FindAuftragByMitarbeiter value) {
        return new JAXBElement<FindAuftragByMitarbeiter>(_FindAuftragByMitarbeiter_QNAME, FindAuftragByMitarbeiter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByNameVornameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByNameVornameResponse")
    public JAXBElement<FindMitarbeiterByNameVornameResponse> createFindMitarbeiterByNameVornameResponse(FindMitarbeiterByNameVornameResponse value) {
        return new JAXBElement<FindMitarbeiterByNameVornameResponse>(_FindMitarbeiterByNameVornameResponse_QNAME, FindMitarbeiterByNameVornameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByOrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByOrt")
    public JAXBElement<FindMitarbeiterByOrt> createFindMitarbeiterByOrt(FindMitarbeiterByOrt value) {
        return new JAXBElement<FindMitarbeiterByOrt>(_FindMitarbeiterByOrt_QNAME, FindMitarbeiterByOrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateBenutzerResponse")
    public JAXBElement<UpdateBenutzerResponse> createUpdateBenutzerResponse(UpdateBenutzerResponse value) {
        return new JAXBElement<UpdateBenutzerResponse>(_UpdateBenutzerResponse_QNAME, UpdateBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByOrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByOrt")
    public JAXBElement<FindKontaktByOrt> createFindKontaktByOrt(FindKontaktByOrt value) {
        return new JAXBElement<FindKontaktByOrt>(_FindKontaktByOrt_QNAME, FindKontaktByOrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAuftrag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addAuftrag")
    public JAXBElement<AddAuftrag> createAddAuftrag(AddAuftrag value) {
        return new JAXBElement<AddAuftrag>(_AddAuftrag_QNAME, AddAuftrag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByStrasse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByStrasse")
    public JAXBElement<FindMitarbeiterByStrasse> createFindMitarbeiterByStrasse(FindMitarbeiterByStrasse value) {
        return new JAXBElement<FindMitarbeiterByStrasse>(_FindMitarbeiterByStrasse_QNAME, FindMitarbeiterByStrasse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByVorname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByVorname")
    public JAXBElement<FindMitarbeiterByVorname> createFindMitarbeiterByVorname(FindMitarbeiterByVorname value) {
        return new JAXBElement<FindMitarbeiterByVorname>(_FindMitarbeiterByVorname_QNAME, FindMitarbeiterByVorname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWaermeerzeuger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteWaermeerzeuger")
    public JAXBElement<DeleteWaermeerzeuger> createDeleteWaermeerzeuger(DeleteWaermeerzeuger value) {
        return new JAXBElement<DeleteWaermeerzeuger>(_DeleteWaermeerzeuger_QNAME, DeleteWaermeerzeuger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllKontakte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllKontakte")
    public JAXBElement<FindAllKontakte> createFindAllKontakte(FindAllKontakte value) {
        return new JAXBElement<FindAllKontakte>(_FindAllKontakte_QNAME, FindAllKontakte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageByIdResponse")
    public JAXBElement<FindFeuerungsanlageByIdResponse> createFindFeuerungsanlageByIdResponse(FindFeuerungsanlageByIdResponse value) {
        return new JAXBElement<FindFeuerungsanlageByIdResponse>(_FindFeuerungsanlageByIdResponse_QNAME, FindFeuerungsanlageByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddKontakt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addKontakt")
    public JAXBElement<AddKontakt> createAddKontakt(AddKontakt value) {
        return new JAXBElement<AddKontakt>(_AddKontakt_QNAME, AddKontakt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByKontakt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByKontakt")
    public JAXBElement<FindAuftragByKontakt> createFindAuftragByKontakt(FindAuftragByKontakt value) {
        return new JAXBElement<FindAuftragByKontakt>(_FindAuftragByKontakt_QNAME, FindAuftragByKontakt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOrtById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteOrtById")
    public JAXBElement<DeleteOrtById> createDeleteOrtById(DeleteOrtById value) {
        return new JAXBElement<DeleteOrtById>(_DeleteOrtById_QNAME, DeleteOrtById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateKontakt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateKontakt")
    public JAXBElement<UpdateKontakt> createUpdateKontakt(UpdateKontakt value) {
        return new JAXBElement<UpdateKontakt>(_UpdateKontakt_QNAME, UpdateKontakt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateBenutzer")
    public JAXBElement<UpdateBenutzer> createUpdateBenutzer(UpdateBenutzer value) {
        return new JAXBElement<UpdateBenutzer>(_UpdateBenutzer_QNAME, UpdateBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByOrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByOrtResponse")
    public JAXBElement<FindKontaktByOrtResponse> createFindKontaktByOrtResponse(FindKontaktByOrtResponse value) {
        return new JAXBElement<FindKontaktByOrtResponse>(_FindKontaktByOrtResponse_QNAME, FindKontaktByOrtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllKontakteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllKontakteResponse")
    public JAXBElement<FindAllKontakteResponse> createFindAllKontakteResponse(FindAllKontakteResponse value) {
        return new JAXBElement<FindAllKontakteResponse>(_FindAllKontakteResponse_QNAME, FindAllKontakteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageById")
    public JAXBElement<FindFeuerungsanlageById> createFindFeuerungsanlageById(FindFeuerungsanlageById value) {
        return new JAXBElement<FindFeuerungsanlageById>(_FindFeuerungsanlageById_QNAME, FindFeuerungsanlageById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessung }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addMessung")
    public JAXBElement<AddMessung> createAddMessung(AddMessung value) {
        return new JAXBElement<AddMessung>(_AddMessung_QNAME, AddMessung.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllMessungResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllMessungResponse")
    public JAXBElement<FindAllMessungResponse> createFindAllMessungResponse(FindAllMessungResponse value) {
        return new JAXBElement<FindAllMessungResponse>(_FindAllMessungResponse_QNAME, FindAllMessungResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFeuerungsanlage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteFeuerungsanlage")
    public JAXBElement<DeleteFeuerungsanlage> createDeleteFeuerungsanlage(DeleteFeuerungsanlage value) {
        return new JAXBElement<DeleteFeuerungsanlage>(_DeleteFeuerungsanlage_QNAME, DeleteFeuerungsanlage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllKontaktResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllKontaktResponse")
    public JAXBElement<FindAllKontaktResponse> createFindAllKontaktResponse(FindAllKontaktResponse value) {
        return new JAXBElement<FindAllKontaktResponse>(_FindAllKontaktResponse_QNAME, FindAllKontaktResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllLiegenschaftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllLiegenschaftResponse")
    public JAXBElement<FindAllLiegenschaftResponse> createFindAllLiegenschaftResponse(FindAllLiegenschaftResponse value) {
        return new JAXBElement<FindAllLiegenschaftResponse>(_FindAllLiegenschaftResponse_QNAME, FindAllLiegenschaftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateOrt")
    public JAXBElement<UpdateOrt> createUpdateOrt(UpdateOrt value) {
        return new JAXBElement<UpdateOrt>(_UpdateOrt_QNAME, UpdateOrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerByIdResponse")
    public JAXBElement<FindBrennerByIdResponse> createFindBrennerByIdResponse(FindBrennerByIdResponse value) {
        return new JAXBElement<FindBrennerByIdResponse>(_FindBrennerByIdResponse_QNAME, FindBrennerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllAuftrag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllAuftrag")
    public JAXBElement<FindAllAuftrag> createFindAllAuftrag(FindAllAuftrag value) {
        return new JAXBElement<FindAllAuftrag>(_FindAllAuftrag_QNAME, FindAllAuftrag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByArbeitetSeitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByArbeitetSeitResponse")
    public JAXBElement<FindMitarbeiterByArbeitetSeitResponse> createFindMitarbeiterByArbeitetSeitResponse(FindMitarbeiterByArbeitetSeitResponse value) {
        return new JAXBElement<FindMitarbeiterByArbeitetSeitResponse>(_FindMitarbeiterByArbeitetSeitResponse_QNAME, FindMitarbeiterByArbeitetSeitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMitarbeiterByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMitarbeiterByIdResponse")
    public JAXBElement<DeleteMitarbeiterByIdResponse> createDeleteMitarbeiterByIdResponse(DeleteMitarbeiterByIdResponse value) {
        return new JAXBElement<DeleteMitarbeiterByIdResponse>(_DeleteMitarbeiterByIdResponse_QNAME, DeleteMitarbeiterByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddWaermeerzeuger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addWaermeerzeuger")
    public JAXBElement<AddWaermeerzeuger> createAddWaermeerzeuger(AddWaermeerzeuger value) {
        return new JAXBElement<AddWaermeerzeuger>(_AddWaermeerzeuger_QNAME, AddWaermeerzeuger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllFeuerungsanlageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllFeuerungsanlageResponse")
    public JAXBElement<FindAllFeuerungsanlageResponse> createFindAllFeuerungsanlageResponse(FindAllFeuerungsanlageResponse value) {
        return new JAXBElement<FindAllFeuerungsanlageResponse>(_FindAllFeuerungsanlageResponse_QNAME, FindAllFeuerungsanlageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByVorname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByVorname")
    public JAXBElement<FindKontaktByVorname> createFindKontaktByVorname(FindKontaktByVorname value) {
        return new JAXBElement<FindKontaktByVorname>(_FindKontaktByVorname_QNAME, FindKontaktByVorname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateOrtResponse")
    public JAXBElement<UpdateOrtResponse> createUpdateOrtResponse(UpdateOrtResponse value) {
        return new JAXBElement<UpdateOrtResponse>(_UpdateOrtResponse_QNAME, UpdateOrtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBenutzerByUsernamePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBenutzerByUsernamePasswordResponse")
    public JAXBElement<FindBenutzerByUsernamePasswordResponse> createFindBenutzerByUsernamePasswordResponse(FindBenutzerByUsernamePasswordResponse value) {
        return new JAXBElement<FindBenutzerByUsernamePasswordResponse>(_FindBenutzerByUsernamePasswordResponse_QNAME, FindBenutzerByUsernamePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllBenutzerResponse")
    public JAXBElement<FindAllBenutzerResponse> createFindAllBenutzerResponse(FindAllBenutzerResponse value) {
        return new JAXBElement<FindAllBenutzerResponse>(_FindAllBenutzerResponse_QNAME, FindAllBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLiegenschaft }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addLiegenschaft")
    public JAXBElement<AddLiegenschaft> createAddLiegenschaft(AddLiegenschaft value) {
        return new JAXBElement<AddLiegenschaft>(_AddLiegenschaft_QNAME, AddLiegenschaft.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteKontakt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteKontakt")
    public JAXBElement<DeleteKontakt> createDeleteKontakt(DeleteKontakt value) {
        return new JAXBElement<DeleteKontakt>(_DeleteKontakt_QNAME, DeleteKontakt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageByWaermeerzeugerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageByWaermeerzeugerResponse")
    public JAXBElement<FindFeuerungsanlageByWaermeerzeugerResponse> createFindFeuerungsanlageByWaermeerzeugerResponse(FindFeuerungsanlageByWaermeerzeugerResponse value) {
        return new JAXBElement<FindFeuerungsanlageByWaermeerzeugerResponse>(_FindFeuerungsanlageByWaermeerzeugerResponse_QNAME, FindFeuerungsanlageByWaermeerzeugerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByMitarbeiterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByMitarbeiterResponse")
    public JAXBElement<FindAuftragByMitarbeiterResponse> createFindAuftragByMitarbeiterResponse(FindAuftragByMitarbeiterResponse value) {
        return new JAXBElement<FindAuftragByMitarbeiterResponse>(_FindAuftragByMitarbeiterResponse_QNAME, FindAuftragByMitarbeiterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerById")
    public JAXBElement<FindBrennerById> createFindBrennerById(FindBrennerById value) {
        return new JAXBElement<FindBrennerById>(_FindBrennerById_QNAME, FindBrennerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteKontaktById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteKontaktById")
    public JAXBElement<DeleteKontaktById> createDeleteKontaktById(DeleteKontaktById value) {
        return new JAXBElement<DeleteKontaktById>(_DeleteKontaktById_QNAME, DeleteKontaktById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddKontaktResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addKontaktResponse")
    public JAXBElement<AddKontaktResponse> createAddKontaktResponse(AddKontaktResponse value) {
        return new JAXBElement<AddKontaktResponse>(_AddKontaktResponse_QNAME, AddKontaktResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLiegenschaftByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteLiegenschaftByIdResponse")
    public JAXBElement<DeleteLiegenschaftByIdResponse> createDeleteLiegenschaftByIdResponse(DeleteLiegenschaftByIdResponse value) {
        return new JAXBElement<DeleteLiegenschaftByIdResponse>(_DeleteLiegenschaftByIdResponse_QNAME, DeleteLiegenschaftByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerByBaujahr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerByBaujahr")
    public JAXBElement<FindBrennerByBaujahr> createFindBrennerByBaujahr(FindBrennerByBaujahr value) {
        return new JAXBElement<FindBrennerByBaujahr>(_FindBrennerByBaujahr_QNAME, FindBrennerByBaujahr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBenutzerByUsernamePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBenutzerByUsernamePassword")
    public JAXBElement<FindBenutzerByUsernamePassword> createFindBenutzerByUsernamePassword(FindBenutzerByUsernamePassword value) {
        return new JAXBElement<FindBenutzerByUsernamePassword>(_FindBenutzerByUsernamePassword_QNAME, FindBenutzerByUsernamePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMitarbeiterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateMitarbeiterResponse")
    public JAXBElement<UpdateMitarbeiterResponse> createUpdateMitarbeiterResponse(UpdateMitarbeiterResponse value) {
        return new JAXBElement<UpdateMitarbeiterResponse>(_UpdateMitarbeiterResponse_QNAME, UpdateMitarbeiterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrtByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findOrtByIdResponse")
    public JAXBElement<FindOrtByIdResponse> createFindOrtByIdResponse(FindOrtByIdResponse value) {
        return new JAXBElement<FindOrtByIdResponse>(_FindOrtByIdResponse_QNAME, FindOrtByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMessung }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMessung")
    public JAXBElement<DeleteMessung> createDeleteMessung(DeleteMessung value) {
        return new JAXBElement<DeleteMessung>(_DeleteMessung_QNAME, DeleteMessung.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByDatum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByDatum")
    public JAXBElement<FindAuftragByDatum> createFindAuftragByDatum(FindAuftragByDatum value) {
        return new JAXBElement<FindAuftragByDatum>(_FindAuftragByDatum_QNAME, FindAuftragByDatum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftByStrasse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftByStrasse")
    public JAXBElement<FindLiegenschaftByStrasse> createFindLiegenschaftByStrasse(FindLiegenschaftByStrasse value) {
        return new JAXBElement<FindLiegenschaftByStrasse>(_FindLiegenschaftByStrasse_QNAME, FindLiegenschaftByStrasse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMitarbeiter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateMitarbeiter")
    public JAXBElement<UpdateMitarbeiter> createUpdateMitarbeiter(UpdateMitarbeiter value) {
        return new JAXBElement<UpdateMitarbeiter>(_UpdateMitarbeiter_QNAME, UpdateMitarbeiter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAuftragResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addAuftragResponse")
    public JAXBElement<AddAuftragResponse> createAddAuftragResponse(AddAuftragResponse value) {
        return new JAXBElement<AddAuftragResponse>(_AddAuftragResponse_QNAME, AddAuftragResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageByLiegenschaftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageByLiegenschaftResponse")
    public JAXBElement<FindFeuerungsanlageByLiegenschaftResponse> createFindFeuerungsanlageByLiegenschaftResponse(FindFeuerungsanlageByLiegenschaftResponse value) {
        return new JAXBElement<FindFeuerungsanlageByLiegenschaftResponse>(_FindFeuerungsanlageByLiegenschaftResponse_QNAME, FindFeuerungsanlageByLiegenschaftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFeuerungsanlageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteFeuerungsanlageResponse")
    public JAXBElement<DeleteFeuerungsanlageResponse> createDeleteFeuerungsanlageResponse(DeleteFeuerungsanlageResponse value) {
        return new JAXBElement<DeleteFeuerungsanlageResponse>(_DeleteFeuerungsanlageResponse_QNAME, DeleteFeuerungsanlageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByVornameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByVornameResponse")
    public JAXBElement<FindKontaktByVornameResponse> createFindKontaktByVornameResponse(FindKontaktByVornameResponse value) {
        return new JAXBElement<FindKontaktByVornameResponse>(_FindKontaktByVornameResponse_QNAME, FindKontaktByVornameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBrennerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteBrennerResponse")
    public JAXBElement<DeleteBrennerResponse> createDeleteBrennerResponse(DeleteBrennerResponse value) {
        return new JAXBElement<DeleteBrennerResponse>(_DeleteBrennerResponse_QNAME, DeleteBrennerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllBenutzer")
    public JAXBElement<FindAllBenutzer> createFindAllBenutzer(FindAllBenutzer value) {
        return new JAXBElement<FindAllBenutzer>(_FindAllBenutzer_QNAME, FindAllBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerByBaujahr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerByBaujahr")
    public JAXBElement<FindWaermeerzeugerByBaujahr> createFindWaermeerzeugerByBaujahr(FindWaermeerzeugerByBaujahr value) {
        return new JAXBElement<FindWaermeerzeugerByBaujahr>(_FindWaermeerzeugerByBaujahr_QNAME, FindWaermeerzeugerByBaujahr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMitarbeiter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addMitarbeiter")
    public JAXBElement<AddMitarbeiter> createAddMitarbeiter(AddMitarbeiter value) {
        return new JAXBElement<AddMitarbeiter>(_AddMitarbeiter_QNAME, AddMitarbeiter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMessungById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMessungById")
    public JAXBElement<FindMessungById> createFindMessungById(FindMessungById value) {
        return new JAXBElement<FindMessungById>(_FindMessungById_QNAME, FindMessungById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllBrennerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllBrennerResponse")
    public JAXBElement<FindAllBrennerResponse> createFindAllBrennerResponse(FindAllBrennerResponse value) {
        return new JAXBElement<FindAllBrennerResponse>(_FindAllBrennerResponse_QNAME, FindAllBrennerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOrtByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteOrtByIdResponse")
    public JAXBElement<DeleteOrtByIdResponse> createDeleteOrtByIdResponse(DeleteOrtByIdResponse value) {
        return new JAXBElement<DeleteOrtByIdResponse>(_DeleteOrtByIdResponse_QNAME, DeleteOrtByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMessung }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateMessung")
    public JAXBElement<UpdateMessung> createUpdateMessung(UpdateMessung value) {
        return new JAXBElement<UpdateMessung>(_UpdateMessung_QNAME, UpdateMessung.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMitarbeiterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMitarbeiterResponse")
    public JAXBElement<DeleteMitarbeiterResponse> createDeleteMitarbeiterResponse(DeleteMitarbeiterResponse value) {
        return new JAXBElement<DeleteMitarbeiterResponse>(_DeleteMitarbeiterResponse_QNAME, DeleteMitarbeiterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWaermeerzeugerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteWaermeerzeugerById")
    public JAXBElement<DeleteWaermeerzeugerById> createDeleteWaermeerzeugerById(DeleteWaermeerzeugerById value) {
        return new JAXBElement<DeleteWaermeerzeugerById>(_DeleteWaermeerzeugerById_QNAME, DeleteWaermeerzeugerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWaermeerzeugerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateWaermeerzeugerResponse")
    public JAXBElement<UpdateWaermeerzeugerResponse> createUpdateWaermeerzeugerResponse(UpdateWaermeerzeugerResponse value) {
        return new JAXBElement<UpdateWaermeerzeugerResponse>(_UpdateWaermeerzeugerResponse_QNAME, UpdateWaermeerzeugerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftByOrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftByOrtResponse")
    public JAXBElement<FindLiegenschaftByOrtResponse> createFindLiegenschaftByOrtResponse(FindLiegenschaftByOrtResponse value) {
        return new JAXBElement<FindLiegenschaftByOrtResponse>(_FindLiegenschaftByOrtResponse_QNAME, FindLiegenschaftByOrtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteKontaktByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteKontaktByIdResponse")
    public JAXBElement<DeleteKontaktByIdResponse> createDeleteKontaktByIdResponse(DeleteKontaktByIdResponse value) {
        return new JAXBElement<DeleteKontaktByIdResponse>(_DeleteKontaktByIdResponse_QNAME, DeleteKontaktByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllWaermeerzeuger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllWaermeerzeuger")
    public JAXBElement<FindAllWaermeerzeuger> createFindAllWaermeerzeuger(FindAllWaermeerzeuger value) {
        return new JAXBElement<FindAllWaermeerzeuger>(_FindAllWaermeerzeuger_QNAME, FindAllWaermeerzeuger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterById")
    public JAXBElement<FindMitarbeiterById> createFindMitarbeiterById(FindMitarbeiterById value) {
        return new JAXBElement<FindMitarbeiterById>(_FindMitarbeiterById_QNAME, FindMitarbeiterById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLiegenschaftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addLiegenschaftResponse")
    public JAXBElement<AddLiegenschaftResponse> createAddLiegenschaftResponse(AddLiegenschaftResponse value) {
        return new JAXBElement<AddLiegenschaftResponse>(_AddLiegenschaftResponse_QNAME, AddLiegenschaftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrtByPlz }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findOrtByPlz")
    public JAXBElement<FindOrtByPlz> createFindOrtByPlz(FindOrtByPlz value) {
        return new JAXBElement<FindOrtByPlz>(_FindOrtByPlz_QNAME, FindOrtByPlz.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByStrasseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByStrasseResponse")
    public JAXBElement<FindKontaktByStrasseResponse> createFindKontaktByStrasseResponse(FindKontaktByStrasseResponse value) {
        return new JAXBElement<FindKontaktByStrasseResponse>(_FindKontaktByStrasseResponse_QNAME, FindKontaktByStrasseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerByBaujahrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerByBaujahrResponse")
    public JAXBElement<FindWaermeerzeugerByBaujahrResponse> createFindWaermeerzeugerByBaujahrResponse(FindWaermeerzeugerByBaujahrResponse value) {
        return new JAXBElement<FindWaermeerzeugerByBaujahrResponse>(_FindWaermeerzeugerByBaujahrResponse_QNAME, FindWaermeerzeugerByBaujahrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBenutzerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBenutzerById")
    public JAXBElement<FindBenutzerById> createFindBenutzerById(FindBenutzerById value) {
        return new JAXBElement<FindBenutzerById>(_FindBenutzerById_QNAME, FindBenutzerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBenutzerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBenutzerByIdResponse")
    public JAXBElement<FindBenutzerByIdResponse> createFindBenutzerByIdResponse(FindBenutzerByIdResponse value) {
        return new JAXBElement<FindBenutzerByIdResponse>(_FindBenutzerByIdResponse_QNAME, FindBenutzerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftByStrasseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftByStrasseResponse")
    public JAXBElement<FindLiegenschaftByStrasseResponse> createFindLiegenschaftByStrasseResponse(FindLiegenschaftByStrasseResponse value) {
        return new JAXBElement<FindLiegenschaftByStrasseResponse>(_FindLiegenschaftByStrasseResponse_QNAME, FindLiegenschaftByStrasseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByRolleExtern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByRolleExtern")
    public JAXBElement<FindKontaktByRolleExtern> createFindKontaktByRolleExtern(FindKontaktByRolleExtern value) {
        return new JAXBElement<FindKontaktByRolleExtern>(_FindKontaktByRolleExtern_QNAME, FindKontaktByRolleExtern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByArbeitetBisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByArbeitetBisResponse")
    public JAXBElement<FindMitarbeiterByArbeitetBisResponse> createFindMitarbeiterByArbeitetBisResponse(FindMitarbeiterByArbeitetBisResponse value) {
        return new JAXBElement<FindMitarbeiterByArbeitetBisResponse>(_FindMitarbeiterByArbeitetBisResponse_QNAME, FindMitarbeiterByArbeitetBisResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteBenutzer")
    public JAXBElement<DeleteBenutzer> createDeleteBenutzer(DeleteBenutzer value) {
        return new JAXBElement<DeleteBenutzer>(_DeleteBenutzer_QNAME, DeleteBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBrennerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteBrennerById")
    public JAXBElement<DeleteBrennerById> createDeleteBrennerById(DeleteBrennerById value) {
        return new JAXBElement<DeleteBrennerById>(_DeleteBrennerById_QNAME, DeleteBrennerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByStrasse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByStrasse")
    public JAXBElement<FindKontaktByStrasse> createFindKontaktByStrasse(FindKontaktByStrasse value) {
        return new JAXBElement<FindKontaktByStrasse>(_FindKontaktByStrasse_QNAME, FindKontaktByStrasse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerByTyp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerByTyp")
    public JAXBElement<FindWaermeerzeugerByTyp> createFindWaermeerzeugerByTyp(FindWaermeerzeugerByTyp value) {
        return new JAXBElement<FindWaermeerzeugerByTyp>(_FindWaermeerzeugerByTyp_QNAME, FindWaermeerzeugerByTyp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFeuerungsanlageByBrennerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findFeuerungsanlageByBrennerResponse")
    public JAXBElement<FindFeuerungsanlageByBrennerResponse> createFindFeuerungsanlageByBrennerResponse(FindFeuerungsanlageByBrennerResponse value) {
        return new JAXBElement<FindFeuerungsanlageByBrennerResponse>(_FindFeuerungsanlageByBrennerResponse_QNAME, FindFeuerungsanlageByBrennerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFeuerungsanlageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateFeuerungsanlageResponse")
    public JAXBElement<UpdateFeuerungsanlageResponse> createUpdateFeuerungsanlageResponse(UpdateFeuerungsanlageResponse value) {
        return new JAXBElement<UpdateFeuerungsanlageResponse>(_UpdateFeuerungsanlageResponse_QNAME, UpdateFeuerungsanlageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllMessung }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllMessung")
    public JAXBElement<FindAllMessung> createFindAllMessung(FindAllMessung value) {
        return new JAXBElement<FindAllMessung>(_FindAllMessung_QNAME, FindAllMessung.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByArbeitetSeit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByArbeitetSeit")
    public JAXBElement<FindMitarbeiterByArbeitetSeit> createFindMitarbeiterByArbeitetSeit(FindMitarbeiterByArbeitetSeit value) {
        return new JAXBElement<FindMitarbeiterByArbeitetSeit>(_FindMitarbeiterByArbeitetSeit_QNAME, FindMitarbeiterByArbeitetSeit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addBenutzerResponse")
    public JAXBElement<AddBenutzerResponse> createAddBenutzerResponse(AddBenutzerResponse value) {
        return new JAXBElement<AddBenutzerResponse>(_AddBenutzerResponse_QNAME, AddBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteOrt")
    public JAXBElement<DeleteOrt> createDeleteOrt(DeleteOrt value) {
        return new JAXBElement<DeleteOrt>(_DeleteOrt_QNAME, DeleteOrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFeuerungsanlage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addFeuerungsanlage")
    public JAXBElement<AddFeuerungsanlage> createAddFeuerungsanlage(AddFeuerungsanlage value) {
        return new JAXBElement<AddFeuerungsanlage>(_AddFeuerungsanlage_QNAME, AddFeuerungsanlage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByIdResponse")
    public JAXBElement<FindKontaktByIdResponse> createFindKontaktByIdResponse(FindKontaktByIdResponse value) {
        return new JAXBElement<FindKontaktByIdResponse>(_FindKontaktByIdResponse_QNAME, FindKontaktByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByIdResponse")
    public JAXBElement<FindMitarbeiterByIdResponse> createFindMitarbeiterByIdResponse(FindMitarbeiterByIdResponse value) {
        return new JAXBElement<FindMitarbeiterByIdResponse>(_FindMitarbeiterByIdResponse_QNAME, FindMitarbeiterByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByStrasseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByStrasseResponse")
    public JAXBElement<FindMitarbeiterByStrasseResponse> createFindMitarbeiterByStrasseResponse(FindMitarbeiterByStrasseResponse value) {
        return new JAXBElement<FindMitarbeiterByStrasseResponse>(_FindMitarbeiterByStrasseResponse_QNAME, FindMitarbeiterByStrasseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBrenner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteBrenner")
    public JAXBElement<DeleteBrenner> createDeleteBrenner(DeleteBrenner value) {
        return new JAXBElement<DeleteBrenner>(_DeleteBrenner_QNAME, DeleteBrenner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteOrtResponse")
    public JAXBElement<DeleteOrtResponse> createDeleteOrtResponse(DeleteOrtResponse value) {
        return new JAXBElement<DeleteOrtResponse>(_DeleteOrtResponse_QNAME, DeleteOrtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLiegenschaftById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findLiegenschaftById")
    public JAXBElement<FindLiegenschaftById> createFindLiegenschaftById(FindLiegenschaftById value) {
        return new JAXBElement<FindLiegenschaftById>(_FindLiegenschaftById_QNAME, FindLiegenschaftById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByName")
    public JAXBElement<FindMitarbeiterByName> createFindMitarbeiterByName(FindMitarbeiterByName value) {
        return new JAXBElement<FindMitarbeiterByName>(_FindMitarbeiterByName_QNAME, FindMitarbeiterByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMessungByBeurteilungNotOkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMessungByBeurteilungNotOkResponse")
    public JAXBElement<FindMessungByBeurteilungNotOkResponse> createFindMessungByBeurteilungNotOkResponse(FindMessungByBeurteilungNotOkResponse value) {
        return new JAXBElement<FindMessungByBeurteilungNotOkResponse>(_FindMessungByBeurteilungNotOkResponse_QNAME, FindMessungByBeurteilungNotOkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddWaermeerzeugerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addWaermeerzeugerResponse")
    public JAXBElement<AddWaermeerzeugerResponse> createAddWaermeerzeugerResponse(AddWaermeerzeugerResponse value) {
        return new JAXBElement<AddWaermeerzeugerResponse>(_AddWaermeerzeugerResponse_QNAME, AddWaermeerzeugerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMitarbeiterById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMitarbeiterById")
    public JAXBElement<DeleteMitarbeiterById> createDeleteMitarbeiterById(DeleteMitarbeiterById value) {
        return new JAXBElement<DeleteMitarbeiterById>(_DeleteMitarbeiterById_QNAME, DeleteMitarbeiterById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMessungByDatumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMessungByDatumResponse")
    public JAXBElement<FindMessungByDatumResponse> createFindMessungByDatumResponse(FindMessungByDatumResponse value) {
        return new JAXBElement<FindMessungByDatumResponse>(_FindMessungByDatumResponse_QNAME, FindMessungByDatumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMessungByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMessungByIdResponse")
    public JAXBElement<DeleteMessungByIdResponse> createDeleteMessungByIdResponse(DeleteMessungByIdResponse value) {
        return new JAXBElement<DeleteMessungByIdResponse>(_DeleteMessungByIdResponse_QNAME, DeleteMessungByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLiegenschaftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteLiegenschaftResponse")
    public JAXBElement<DeleteLiegenschaftResponse> createDeleteLiegenschaftResponse(DeleteLiegenschaftResponse value) {
        return new JAXBElement<DeleteLiegenschaftResponse>(_DeleteLiegenschaftResponse_QNAME, DeleteLiegenschaftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWaermeerzeugerByTypResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findWaermeerzeugerByTypResponse")
    public JAXBElement<FindWaermeerzeugerByTypResponse> createFindWaermeerzeugerByTypResponse(FindWaermeerzeugerByTypResponse value) {
        return new JAXBElement<FindWaermeerzeugerByTypResponse>(_FindWaermeerzeugerByTypResponse_QNAME, FindWaermeerzeugerByTypResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrtByPlzResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findOrtByPlzResponse")
    public JAXBElement<FindOrtByPlzResponse> createFindOrtByPlzResponse(FindOrtByPlzResponse value) {
        return new JAXBElement<FindOrtByPlzResponse>(_FindOrtByPlzResponse_QNAME, FindOrtByPlzResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMessungById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteMessungById")
    public JAXBElement<DeleteMessungById> createDeleteMessungById(DeleteMessungById value) {
        return new JAXBElement<DeleteMessungById>(_DeleteMessungById_QNAME, DeleteMessungById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFeuerungsanlageByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteFeuerungsanlageByIdResponse")
    public JAXBElement<DeleteFeuerungsanlageByIdResponse> createDeleteFeuerungsanlageByIdResponse(DeleteFeuerungsanlageByIdResponse value) {
        return new JAXBElement<DeleteFeuerungsanlageByIdResponse>(_DeleteFeuerungsanlageByIdResponse_QNAME, DeleteFeuerungsanlageByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllWaermeerzeugerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllWaermeerzeugerResponse")
    public JAXBElement<FindAllWaermeerzeugerResponse> createFindAllWaermeerzeugerResponse(FindAllWaermeerzeugerResponse value) {
        return new JAXBElement<FindAllWaermeerzeugerResponse>(_FindAllWaermeerzeugerResponse_QNAME, FindAllWaermeerzeugerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessungResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addMessungResponse")
    public JAXBElement<AddMessungResponse> createAddMessungResponse(AddMessungResponse value) {
        return new JAXBElement<AddMessungResponse>(_AddMessungResponse_QNAME, AddMessungResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBrennerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteBrennerByIdResponse")
    public JAXBElement<DeleteBrennerByIdResponse> createDeleteBrennerByIdResponse(DeleteBrennerByIdResponse value) {
        return new JAXBElement<DeleteBrennerByIdResponse>(_DeleteBrennerByIdResponse_QNAME, DeleteBrennerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatLiegenschaftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updatLiegenschaftResponse")
    public JAXBElement<UpdatLiegenschaftResponse> createUpdatLiegenschaftResponse(UpdatLiegenschaftResponse value) {
        return new JAXBElement<UpdatLiegenschaftResponse>(_UpdatLiegenschaftResponse_QNAME, UpdatLiegenschaftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addOrtResponse")
    public JAXBElement<AddOrtResponse> createAddOrtResponse(AddOrtResponse value) {
        return new JAXBElement<AddOrtResponse>(_AddOrtResponse_QNAME, AddOrtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWaermeerzeugerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteWaermeerzeugerByIdResponse")
    public JAXBElement<DeleteWaermeerzeugerByIdResponse> createDeleteWaermeerzeugerByIdResponse(DeleteWaermeerzeugerByIdResponse value) {
        return new JAXBElement<DeleteWaermeerzeugerByIdResponse>(_DeleteWaermeerzeugerByIdResponse_QNAME, DeleteWaermeerzeugerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllOrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllOrtResponse")
    public JAXBElement<FindAllOrtResponse> createFindAllOrtResponse(FindAllOrtResponse value) {
        return new JAXBElement<FindAllOrtResponse>(_FindAllOrtResponse_QNAME, FindAllOrtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatLiegenschaft }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updatLiegenschaft")
    public JAXBElement<UpdatLiegenschaft> createUpdatLiegenschaft(UpdatLiegenschaft value) {
        return new JAXBElement<UpdatLiegenschaft>(_UpdatLiegenschaft_QNAME, UpdatLiegenschaft.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerByArt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerByArt")
    public JAXBElement<FindBrennerByArt> createFindBrennerByArt(FindBrennerByArt value) {
        return new JAXBElement<FindBrennerByArt>(_FindBrennerByArt_QNAME, FindBrennerByArt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFeuerungsanlageById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "deleteFeuerungsanlageById")
    public JAXBElement<DeleteFeuerungsanlageById> createDeleteFeuerungsanlageById(DeleteFeuerungsanlageById value) {
        return new JAXBElement<DeleteFeuerungsanlageById>(_DeleteFeuerungsanlageById_QNAME, DeleteFeuerungsanlageById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "addOrt")
    public JAXBElement<AddOrt> createAddOrt(AddOrt value) {
        return new JAXBElement<AddOrt>(_AddOrt_QNAME, AddOrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindKontaktByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findKontaktByName")
    public JAXBElement<FindKontaktByName> createFindKontaktByName(FindKontaktByName value) {
        return new JAXBElement<FindKontaktByName>(_FindKontaktByName_QNAME, FindKontaktByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByRolleInternResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByRolleInternResponse")
    public JAXBElement<FindMitarbeiterByRolleInternResponse> createFindMitarbeiterByRolleInternResponse(FindMitarbeiterByRolleInternResponse value) {
        return new JAXBElement<FindMitarbeiterByRolleInternResponse>(_FindMitarbeiterByRolleInternResponse_QNAME, FindMitarbeiterByRolleInternResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMitarbeiterByOrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findMitarbeiterByOrtResponse")
    public JAXBElement<FindMitarbeiterByOrtResponse> createFindMitarbeiterByOrtResponse(FindMitarbeiterByOrtResponse value) {
        return new JAXBElement<FindMitarbeiterByOrtResponse>(_FindMitarbeiterByOrtResponse_QNAME, FindMitarbeiterByOrtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllOrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllOrt")
    public JAXBElement<FindAllOrt> createFindAllOrt(FindAllOrt value) {
        return new JAXBElement<FindAllOrt>(_FindAllOrt_QNAME, FindAllOrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBrennerByTyp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findBrennerByTyp")
    public JAXBElement<FindBrennerByTyp> createFindBrennerByTyp(FindBrennerByTyp value) {
        return new JAXBElement<FindBrennerByTyp>(_FindBrennerByTyp_QNAME, FindBrennerByTyp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBrenner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateBrenner")
    public JAXBElement<UpdateBrenner> createUpdateBrenner(UpdateBrenner value) {
        return new JAXBElement<UpdateBrenner>(_UpdateBrenner_QNAME, UpdateBrenner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAuftragByDateAndMitarbeiter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAuftragByDateAndMitarbeiter")
    public JAXBElement<FindAuftragByDateAndMitarbeiter> createFindAuftragByDateAndMitarbeiter(FindAuftragByDateAndMitarbeiter value) {
        return new JAXBElement<FindAuftragByDateAndMitarbeiter>(_FindAuftragByDateAndMitarbeiter_QNAME, FindAuftragByDateAndMitarbeiter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllKontakt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "findAllKontakt")
    public JAXBElement<FindAllKontakt> createFindAllKontakt(FindAllKontakt value) {
        return new JAXBElement<FindAllKontakt>(_FindAllKontakt_QNAME, FindAllKontakt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAuftragResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rmi.webservice.feukora/", name = "updateAuftragResponse")
    public JAXBElement<UpdateAuftragResponse> createUpdateAuftragResponse(UpdateAuftragResponse value) {
        return new JAXBElement<UpdateAuftragResponse>(_UpdateAuftragResponse_QNAME, UpdateAuftragResponse.class, null, value);
    }

}
