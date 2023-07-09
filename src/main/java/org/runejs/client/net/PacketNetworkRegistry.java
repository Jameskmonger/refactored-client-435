package org.runejs.client.net;

import org.runejs.client.net.decoder.MessageDecoder;
import org.runejs.client.net.message.InboundMessage;

/**
 * Based on `Release.java` from `Apollo`
 *
 * Copyright (c) 2010-2011 Graham Edgecombe
 * Copyright (c) 2011-2016 Major <major.emrs@gmail.com> and other apollo contributors
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

public class PacketNetworkRegistry {
    /**
     * The array of message decoders.
     */
    private final MessageDecoder<?>[] decoders = new MessageDecoder<?>[256];

    /**
     * Gets the {@link MessageDecoder} for the specified opcode.
     *
     * @param opcode The opcode.
     * @return The message decoder.
     * @throws IndexOutOfBoundsException If the opcode is less than 0, or greater than 255.
     */
    public final MessageDecoder<?> getMessageDecoder(int opcode) {
        if (opcode >= decoders.length) {
            throw new IndexOutOfBoundsException("Opcode out of bounds");
        }

        return decoders[opcode];
    }

    /**
     * Registers a {@link MessageDecoder} for the specified opcode.
     *
     * @param opcode The opcode, between 0 and 255 inclusive.
     * @param decoder The message decoder.
     * @throws IndexOutOfBoundsException If the opcode is less than 0, or greater than 255.
     */
    public final <M extends InboundMessage> void register(int opcode, MessageDecoder<M> decoder) {
        if (opcode >= decoders.length) {
            throw new IndexOutOfBoundsException("Opcode out of bounds");
        }

        decoders[opcode] = decoder;
    }
}
