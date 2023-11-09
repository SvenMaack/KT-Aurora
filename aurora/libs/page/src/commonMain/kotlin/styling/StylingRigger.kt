package page_lib.styling

import css_lib.base.IDocument

interface StylingRigger {
    fun rig(document: IDocument): IDocument
}

class RiggerList(private val list: List<StylingRigger>) : StylingRigger {
    override fun rig(document: IDocument): IDocument =
        list.fold(document) { acc, rigger ->
            rigger.rig(acc)
        }
}
