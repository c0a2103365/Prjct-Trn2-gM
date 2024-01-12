import gc
import subprocess as sp


cmd=["java","-cp","classes","sim.Main"]

with open("log.txt","w",encoding="utf-8")as writefile:
    cp=sp.run(cmd,stdout=writefile)

gc.collect()