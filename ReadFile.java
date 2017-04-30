public class ReadFile {
    public static void main(String[] args) throws 
                                      IOException { 
        Path file = new Path("/path/to/file.txt");
        FileSystem fs = FileSystem.get(new Configuration());
       
        InputStream input = null; 
        try {
            input = fs.open(file);
            IOUtils.copyBytes(input, System.out, 4096); 
        } finally {
            IOUtils.closeStream(input); 
        }
   }
}
