package com.wl.dandan.parameter;

public class RequestParameter {
    private String outputDir;
    private String taxonomyFilePath;
    private String destinationFilePath;


    public String getOutputDir() {
        return outputDir;
    }

    public String getTaxonomyFilePath() {
        return taxonomyFilePath;
    }

    public String getDestinationFilePath() {
        return destinationFilePath;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setTaxonomyFilePath(String taxonomyFilePath) {
        this.taxonomyFilePath = taxonomyFilePath;
    }

    public void setDestinationFilePath(String destinationFilePath) {
        this.destinationFilePath = destinationFilePath;
    }

    public Boolean isMissing(){
        return (null == outputDir && null == taxonomyFilePath && null == destinationFilePath);
    }

    public void validate(){
        if ( null == outputDir || outputDir.isEmpty()){
            throw new IllegalArgumentException("Please specify output directory");
        }

        if ( null == taxonomyFilePath || taxonomyFilePath.isEmpty()){
            throw new IllegalArgumentException("Please specify the taxonomy file location");
        }

        if ( null == destinationFilePath || destinationFilePath.isEmpty()){
            throw new IllegalArgumentException("Please specify the destination file location");
        }
    }
}
