package org.dreamquest.designpatterns.decorator;

import org.dreamquest.util.PropertyUtil;

/**
 *Problem Statement (Decorator Design Pattern)
 *
 * You are building a notification module in a Spring Boot application. The core requirement is to send a basic notification (Email) using a simple interface:
 *
 * - Notifier.send(message)
 *
 * Over time, you need to add optional behaviors to notifications without modifying existing classes and without creating many subclasses for every combination. Examples of optional behaviors:
 * - Send the same message via SMS
 * - Send the same message via Slack
 * - Add logging (log before/after sending)
 * - Add retry on failure (e.g., retry up to 3 times)
 * - Add metrics/tracing (record time taken and success/failure)
 *
 * Constraints / Challenges:
 * - Client code should depend only on the Notifier interface.
 * - Behaviors must be composable at runtime (e.g., Email + SMS + Logging, or Email + Slack + Retry).
 * - You must avoid a subclass explosion (e.g., EmailSmsNotifier, EmailSmsSlackNotifier, EmailRetryNotifier, etc.).
 * - Each added behavior should be implemented independently and should wrap an existing Notifier.
 *
 * Requirement:
 * Implement the Decorator pattern so that additional behaviors can be added dynamically by wrapping a base Notifier, while keeping the same Notifier interface. Demonstrate usage by constructing a Notifier that sends Email, then SMS, then Slack, with Logging enabled, without changing the existing notifier implementations. the decorators to apply multiple styles to the same text.
 */
public class Executor {

    public static void main(String[] args) {

       Notifier notifier = new SlackDecorator(new SmsDecorator(new EmailNotifier()));
       notifier.send("Hello, this is a notification!");
    }
}
