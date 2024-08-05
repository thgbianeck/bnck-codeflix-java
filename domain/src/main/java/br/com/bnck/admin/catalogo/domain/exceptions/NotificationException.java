package br.com.bnck.admin.catalogo.domain.exceptions;

import br.com.bnck.admin.catalogo.domain.validation.handler.Notification;


public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }
}