package com.exemple.controller;

import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Minh Triet
 */
public class MailSender extends Thread{
    static {
        MailSender ms = new MailSender();
        ms.start();
    }
    static final List<MimeMessage> queue = new ArrayList<>();

    public static void queue(MimeMessage mail) {
        synchronized (queue) {
            queue.add(mail);
            queue.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    if (queue.size() > 0) {
                        try {
                            MimeMessage mail = queue.remove(0);
                            Transport.send(mail);
                        } catch (MessagingException e) {

                        }
                    } else {
                        queue.wait();
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
