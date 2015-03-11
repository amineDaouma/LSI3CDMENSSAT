package fr.enssat.services;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import fr.enssat.beans.CDM;
import fr.enssat.dao.CdmDAO;
import fr.enssat.dao.CdmDAOImpl;

public class CDMServiceImpl2 implements CDMService2
{
	private CdmDAO dao = new CdmDAOImpl() ;
	@Override
	public List<CDM> findAll() 
	{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public CDM findByID(String idCDM) 
	{
		// TODO Auto-generated method stub
		return dao.findByID(idCDM);
	}

	@Override
	public CDM updateCDM(String idCDM, CDM newCDM) 
	{
		// TODO Auto-generated method stub
		return dao.updateCDM(idCDM, newCDM);
	}

	@Override
	public CDM addCDM(CDM newCDM) 
	{
		// TODO Auto-generated method stub
		return dao.addCDM(newCDM);
		
	}

	@Override
	public CDM supprimeCDM(String idCDM) 
	{
		// TODO Auto-generated method stub
		return dao.supprimeCDM(idCDM);
	}

	@Override
	public CDM addCDM(String newCDM) 
	{
		
		try 
		{
			JAXBContext context = JAXBContext.newInstance(CDM.class);
			Unmarshaller u = context.createUnmarshaller();
			CDM cdm = (CDM) u.unmarshal(new StringReader(newCDM));
			return dao.addCDM(cdm);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
