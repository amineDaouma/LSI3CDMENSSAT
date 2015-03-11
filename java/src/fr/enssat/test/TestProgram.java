package fr.enssat.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;
import fr.enssat.services.CDMService2;
import fr.enssat.services.CDMServiceImpl2;
import fr.enssat.services.ProgramService;
import fr.enssat.services.ProgramServiceImpl;

public class TestProgram {

	@Test
	public void test_SubProgram() {

		/*** Test de la méthode addSubProgram */
		/* On crée le mock CDM et on le sauve */
		CDM mockCDM = Parseur.xmlToCDM();
		assertNotNull("Probleme Marshling Program", mockCDM);

		String idCDM = mockCDM.getProgram().getProgramID();
		CDMService2 cdmService = new CDMServiceImpl2();
		cdmService.addCDM(mockCDM);

		/* On crée le mock subProgram à ajouter et on l'ajoute */
		SubProgram mockSubProg = Parseur.xmlToSubProgram();
		assertNotNull("Probleme Marshling SubProgram", mockSubProg);
		ProgramService service = new ProgramServiceImpl();
		service.addSubProgram(idCDM, mockSubProg);

		/* On récupère de la bdd le mockCDM */

		/*
		 * Program mockProgRecup = cdmService.findByID(idCDM).getProgram();
		 * List<SubProgram> listeSubProg = mockProgRecup.getSubProgram();
		 * 
		 * assertNotNull("Test_ajout subProgram: liste des subProgram: ",
		 * listeSubProg);
		 */
		// yyyyyyyy
		SubProgram subPrgRecup = service.getSubProgram(idCDM,
				mockSubProg.getId());

		/*
		 * for (SubProgram sprg : listeSubProg) { if
		 * (sprg.getId().equals(mockSubProg.getId())){ subPrgRecup = sprg; } }
		 */
		/* On check que le subPrg n'est pas null */
		assertNotNull("Test_ajout subProgram. Sous_program récupéré: ",
				subPrgRecup);
		assertTrue("Test_ajout subProgram. Equality: ",
				mockSubProg.equals(subPrgRecup));

		/** Test pour la méthode updateSubPrg */
		String idSubPrg = mockSubProg.getId();
		mockSubProg = Parseur.xmlToSubProgram2();
		service.updateSubProgram(idCDM, idSubPrg, mockSubProg);
		// Test
		/*
		 * mockProgRecup = cdmService.findByID(idCDM).getProgram(); listeSubProg
		 * = mockProgRecup.getSubProgram();
		 */

		subPrgRecup = service.getSubProgram(idCDM, mockSubProg.getId());
		/*
		 * assertNotNull("Test_ajout subProgram: liste des subProgram: ",
		 * listeSubProg); subPrgRecup = null;
		 * 
		 * for (SubProgram sprg : listeSubProg) { if
		 * (sprg.getId().equals(mockSubProg.getId())){ subPrgRecup = sprg; } }
		 */
		/* On check que le subPrg n'est pas null */
		assertNotNull("Test_update subProgram. Sous_program récupéré: ",
				subPrgRecup);
		assertTrue("Test_update subProgram. Equality: ",
				mockSubProg.equals(subPrgRecup));

		/** Test pour la méthode getSubPrg */
		subPrgRecup = service.getSubProgram(
				mockCDM.getProgram().getProgramID(), mockSubProg.getId());
		assertTrue("Test_get subProgram. Equality: ",
				subPrgRecup.equals(mockSubProg));

		/*** Test pour la méthode deleteSubPrg */
		service.deleteSubProgram(idCDM, mockSubProg.getId());
		/*
		 * mockProgRecup = cdmService.findByID(idCDM).getProgram(); listeSubProg
		 * = mockProgRecup.getSubProgram();
		 * 
		 * assertNotNull("Test_ajout subProgram: liste des subProgram: ",
		 * listeSubProg); subPrgRecup = null; for (SubProgram sprg :
		 * listeSubProg) { if (sprg.getId().equals(mockSubProg.getId())){
		 * subPrgRecup = sprg; } }
		 */

		subPrgRecup = service.getSubProgram(
				mockCDM.getProgram().getProgramID(), mockSubProg.getId());
		assertNull("Test_Suppr subPrg: ", subPrgRecup);

		cdmService.supprimeCDM(idCDM);
	}

	@Test
	public void test_Program() {

		/**** Test de la méthode updateProgram et getProgram */
		/* On crée le mock CDM et on le sauve */
		CDM mockCDM = Parseur.xmlToCDM();
		CDMService2 cdmServ = new CDMServiceImpl2();
		cdmServ.addCDM(mockCDM);

		/* On crée le mockProgram et on le sauve */
		Program mockPrg = Parseur.xmlToProgram();
		ProgramService progServ = new ProgramServiceImpl();
		Program progRecup = progServ.updateProgram(mockCDM.getProgram()
				.getProgramID(), mockPrg);

		/* On récupère le mockProgram sauvé */
		progRecup = progServ.getProgram(mockCDM.getProgram().getProgramID());
		assertTrue("Test_get Program. Equality: ", progRecup.equals(mockPrg));

		/* On supprime le mockCDM sauvé */
		cdmServ.supprimeCDM(mockCDM.getProgram().getProgramID());
	}

}
