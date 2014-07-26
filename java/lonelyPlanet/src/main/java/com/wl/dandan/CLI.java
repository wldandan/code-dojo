package com.wl.dandan;

import com.wl.dandan.parameter.RequestParameter;
import com.wl.dandan.view.generator.PageGenerator;
import org.apache.commons.cli.*;

public class CLI {


    public static void main(String[] args){
        RequestParameter parameter = null;
        try {
            parameter = parseOptions(args);
        } catch (Exception e) {
            System.exit(1);
        }

        PageGenerator pageGenerator = new PageGenerator(parameter.getOutputDir());
        Application application = new Application();
        try {
            application.initializeTaxonomy(parameter.getTaxonomyFilePath());
        } catch (Exception e) {
            System.err.println("[Processing Error] Can not process taxonomy file.");
            System.exit(1);
        }

        try {
            application.run(parameter.getDestinationFilePath(), pageGenerator);
        } catch (Exception e) {
            System.err.println("[Processing Error] Can not process destination file.");
            System.exit(1);
        }

    }

    private static Options buildOptions(){
        Option help = new Option("h", "help", false, "Shows the help message");
        Option verbose = new Option("v", "verbose", false, "verbose output");

        Option taxonomy = OptionBuilder
                .withArgName("taxonomy")
                .withLongOpt("taxonomy")
                .hasArg()
                .withDescription("taxonomy file location")
                .create("t");

        Option destination = OptionBuilder
                .withArgName("destination")
                .withLongOpt("destination")
                .hasArg()
                .withDescription("detination file location")
                .create("d");

        Option outputDir = OptionBuilder
                .withArgName("outputDir")
                .withLongOpt("outputDir")
                .hasArg()
                .withDescription("output directory")
                .create("o");

        Options options = new Options();
        options.addOption(help);
        options.addOption(verbose);
        options.addOption(taxonomy);
        options.addOption(destination);
        options.addOption(outputDir);
        return options;
    }

    private static RequestParameter parseOptions(String[] args) {
        CommandLineParser parser = new GnuParser();
        Options options = buildOptions();

        RequestParameter parameter = new RequestParameter();
        try
        {
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("help"))
            {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("PageGenerator", options);
            } else
            {
                if (line.hasOption("taxonomy"))
                {
                    parameter.setTaxonomyFilePath(line.getOptionValue("taxonomy"));

                }
                if (line.hasOption("destination"))
                {
                    parameter.setDestinationFilePath(line.getOptionValue("destination"));
                }
                if (line.hasOption("outputDir"))
                {
                    parameter.setOutputDir(line.getOptionValue("outputDir"));
                }
            }
        } catch (Exception exp){}


        if (parameter.isMissing()){
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("PageGenerator", options);
            System.exit(1);
        }

        try{
            parameter.validate();
        }
        catch (Exception e){
            System.err.println("[Argument Error] " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("PageGenerator", options);
            throw e;
        }
        return parameter;
    }
}
