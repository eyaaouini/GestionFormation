package com.esprit.examen.services;

import com.esprit.examen.entities.Session;

public interface ISessionService {

	Long modifierAddSession(Session session);

	void affecterFormateurASession(Long formateurId, Long sessionId);

	void supprimerSession(Session sessionId);
}
