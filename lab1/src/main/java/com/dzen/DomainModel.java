package com.dzen;

public class DomainModel {

    public static class Кит {
        private String положение;
        private Осознание осознание;
        private int времяНаОсознание;

        public Кит(String положение, int времяНаОсознание) {
            this.положение = положение;
            this.времяНаОсознание = времяНаОсознание;
            this.осознание = new Осознание("осознание того, что оно кит");
        }

        public String getПоложение() {
            return положение;
        }

        public int getВремяНаОсознание() {
            return времяНаОсознание;
        }

        public String getОсознание() {
            return осознание.getОписание();
        }

        public void измениться(String новоеПоложение, String новоеОсознание) {
            this.положение = новоеПоложение;
            this.осознание = new Осознание(новоеОсознание);
        }
    }

    public static class Осознание {
        private String описание;

        public Осознание(String описание) {
            this.описание = описание;
        }

        public String getОписание() {
            return описание;
        }
    }

    public static void main(String[] args) {
        Кит кит = new Кит("далеко не самое естественное", 10);
        System.out.println("Положение кита: " + кит.getПоложение());
        System.out.println("Время на осознание: " + кит.getВремяНаОсознание());
        System.out.println("Осознание: " + кит.getОсознание());

        // Изменение состояния кита
        кит.измениться("уже больше не кит", "осознание того, что оно уже больше не кит");
        System.out.println("Новое положение кита: " + кит.getПоложение());
        System.out.println("Новое осознание: " + кит.getОсознание());
    }
}
