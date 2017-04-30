public class WriteToFile {
    public static void main(String[] args) throws
                                       IOException {
        String text = "Hello world in HDFS!\n"; 
        InputStream in = new BufferedInputStream(new ByteArrayInputStream(text.getBytes()));
        
        Path file = new Path("/path/to/file.txt"); 
        Configuration conf = new Configuration();
        
        FileSystem fs = FileSystem.get(conf);
        
        FSDataOutputStream out = fs.create(file);
        IOUtils.copyBytes(in, out, conf); // Copy Data 
    }
}
