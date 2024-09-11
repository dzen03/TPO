package com.dzen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DomainModelTest {

    @Test
    public void testInitialKitState() {
        DomainModel.Кит кит = new DomainModel.Кит("далеко не самое естественное", 10);
        assertEquals("далеко не самое естественное", кит.getПоложение());
        assertEquals(10, кит.getВремяНаОсознание());
        assertEquals("осознание того, что оно кит", кит.getОсознание());
    }

    @Test
    public void testKitStateChange() {
        DomainModel.Кит кит = new DomainModel.Кит("далеко не самое естественное", 10);
        кит.измениться("уже больше не кит", "осознание того, что оно уже больше не кит");
        assertEquals("уже больше не кит", кит.getПоложение());
        assertEquals("осознание того, что оно уже больше не кит", кит.getОсознание());
    }
}
