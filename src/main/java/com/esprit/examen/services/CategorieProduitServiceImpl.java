package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		
		return categorieProduitRepository.findAll();
	}

	@Override
	public CategorieProduit addCategorieProduit(CategorieProduit cProduit) {
		categorieProduitRepository.save(cProduit);
		return cProduit;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	@Override
	public CategorieProduit updateCategorieProduit(CategorieProduit cProduit) {
		categorieProduitRepository.save(cProduit);
		return cProduit;
	}

	@Override
	public CategorieProduit retrieveCategorieProduit(Long id) {
		CategorieProduit categorieProduit = categorieProduitRepository.findById(id).orElse(null);
		return categorieProduit;
	}

}
