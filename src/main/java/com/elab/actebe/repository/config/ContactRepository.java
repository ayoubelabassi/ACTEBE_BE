package com.elab.actebe.repository.config;

import com.elab.actebe.domaine.speaker.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
