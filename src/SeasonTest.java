enum  SeasonTest implements Info {
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","烈日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    };
    private final String seasonName;
    private final String seasonDec;
    private SeasonTest(String seasonName,String seasonDec){
        this.seasonName=seasonName;
        this.seasonDec=seasonDec;
    }
}
interface Info{
    void show();
}
class Test{
    public static void main(String[] args) {
        SeasonTest.SPRING.show();
    }
}


