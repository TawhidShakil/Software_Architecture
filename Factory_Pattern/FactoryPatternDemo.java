package Factory_Pattern;

interface Report{
    void reportGenerate();
}


// concreate products

class StudentReport implements Report{
    public void reportGenerate(){
        System.out.println("Students report are genereated!");
    }
}

class FacultyReport implements Report{
    public void reportGenerate(){
        System.out.println("Faculty's Report are generated!");
    }
}

class StaffReport implements Report{
    public void reportGenerate(){
        System.out.println("Staff's Report are generated!");
    }
}

 
// creator

class ReportGenerator{
    Report createReport(String type){
        Report report = null;
        if(type.equals("student")){
            report = new StudentReport();
        }else if(type.equals("faculty")){
            report = new FacultyReport();
        }else if(type.equals("staff")){
            report = new StaffReport();
        }

        return report;
    }
}


// concreate creator

class FactoryPatternDemo{
    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        Report report = reportGenerator.createReport("student");
        report.reportGenerate();
    }
}