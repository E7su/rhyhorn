public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
  
    private final static IntWritable one = new IntWritable(1);
    private final Text word = new Text();
  
    @Override
    protected void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
        StringTokenizer tokenizer = new StringTokenizer(value.toString());
          
        while (tokenizer.hasMoreTokens()) {
            word.set(tokenizer.nextToken());
            context.write(word, one);
        }
    }
}

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) 
      throws IOException, InterruptedException {

        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }

        context.getCounter("Reduce", "Words").increment(1);

        context.write(key, new IntWritable(sum));
    }
}
