package com.esprit.examen.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class FornisseurServiceImpTest {
	
	@Autowired
	IFournisseurService fornisseurservice;
	
	@Mock
	FournisseurRepository fournisseurRepository; 
	
	Fournisseur f1=new Fournisseur(1L,"dodo","choco");
	Fournisseur f2=new Fournisseur(1L,"codooo","bobo");
    
	
	@Test
	@Order(1)
	public void testretrieveAllFournisseurs() {
    	when(fournisseurRepository.findAll()).thenReturn(Stream
    			.of(f1,f2)
    			.collect(Collectors.toList()));
    	assertEquals(2,fornisseurservice.retrieveAllFournisseurs().size());
    	System.out.println("Retrieve  All fornisseurs works !");
    }
	
	
	@Test
	@Order(2)
	public void testaddFournisseur() {
    	when(fournisseurRepository.save(f1)).thenReturn(f1);
    	assertNotNull(f1);
		assertEquals(f1, fornisseurservice.addFournisseur(f1));
    	System.out.println("Add Fournisseur works !");
	}
	
	
	@Test
	@Order(3)
	public void testdeleteFournisseur() {
		fournisseurRepository.save(f1);
		fornisseurservice.deleteFournisseur(f1.getIdFournisseur());
		verify(fournisseurRepository, times(1)).deleteById(f1.getIdFournisseur());
		System.out.println("Delete Fournisseur works !");
		
	}
	
	@Test
	@Order(4)
	public void testretrieveFournisseur() {
		when(fournisseurRepository.findById(f1.getIdFournisseur())).thenReturn(Optional.of(f1));
		assertEquals(f1, fornisseurservice.retrieveFournisseur(f1.getIdFournisseur()));
		System.out.println("Retrieve Fournisseur works !");
	}
	
	@Test
	@Order(5)
	public void testupdateFournisseur() {
		when(fournisseurRepository.save(f1)).thenReturn(f1);
		assertNotNull(f1);
		assertEquals(f1, fornisseurservice.updateFournisseur(f1));
		System.out.println("update Fournisseur works !");
	}

	/*@Test
	@Order(5 )
	@Transactional

	public void testassignSecteurActiviteToFournisseur()  throws ParseException {
		Fournisseur f = new Fournisseur();	
		Fournisseur fournisseur = fornisseurservice.addFournisseur(f);
 
	} */
}
