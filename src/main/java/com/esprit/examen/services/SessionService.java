package com.esprit.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class SessionService implements ISessionService {

	@Autowired
	SessionRepository sessionRepository;

	@Autowired
	FormateurRepository formateurRepository;

	@Override
	public Long modifierAddSession(Session session) {
		sessionRepository.save(session);
		return session.getId();
	}

	@Override
	public void supprimerSession(Session sessionId) {
		sessionRepository.delete(sessionId);
	}

	@Override
	public void affecterFormateurASession(Long formateurId, Long sessionId) {
		sessionRepository.getOne(sessionId).setFormateur(formateurRepository.getOne(sessionId));

	}

}
