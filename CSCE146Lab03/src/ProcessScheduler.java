/*
 * Written by Anna Phan
 */
public class ProcessScheduler {
    QueueI <Process> processes;
    private Process currentProcess;
    public ProcessScheduler()
    {
        processes = new LLQueue<Process>();
        this.currentProcess = null;
    }
    //no parameters and returns the currently running process
    public Process getCurrentProcess()
    {
        return this.currentProcess;
    }
    //Taking in a process via a parameter it either sets the current process if the current process is null or it adds it to the process queue
    public void addProcess(Process p)
    {
        if(currentProcess==null)
            this.currentProcess = p;
        else
            processes.enqueue(p);
    }
    //dequeues from the process queue and sets that to the current process
    public void runNextProcess()
    {
        currentProcess = processes.dequeue();
    }
    //current process is cancelled and is replaced by the first element on the process queue
    public void cancelCurrentProcess()
    {
        processes.dequeue();
    }
    //print all of the elements from the process queue
    public void printProcessQueue()
    {
        processes.print();
    }
}
